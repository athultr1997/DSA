use core::panic;
use std::{cell::RefCell, cmp::min, collections::VecDeque, rc::Rc};

#[derive(PartialEq)]
pub struct TreeNode {
    value: i64,
    left: Option<Rc<RefCell<TreeNode>>>,
    right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    fn new(
        value: i64,
        left: Option<Rc<RefCell<TreeNode>>>,
        right: Option<Rc<RefCell<TreeNode>>>,
    ) -> Self {
        TreeNode { value, left, right }
    }
}

pub struct WinnerTree {
    head: Option<Rc<RefCell<TreeNode>>>,
}

impl WinnerTree {
    /// Before and after calling initialize, the WinnerTree is valid.
    pub fn initialize(values: Vec<i64>) -> Self {
        let mut len = values.len();
        let tree_height = usize::try_from(len.ilog2()).unwrap();
        let mut nodes: Vec<Rc<RefCell<TreeNode>>> = vec![];
        for j in 0..tree_height + 1 {
            for i in 0..(len) {
                if j == 0 {
                    nodes.push(Rc::new(RefCell::new(TreeNode::new(values[i], None, None))));
                } else {
                    let value = min(nodes[i * 2].borrow().value, nodes[i * 2 + 1].borrow().value);
                    nodes[i] = Rc::new(RefCell::new(TreeNode::new(
                        value,
                        Some(nodes[i * 2].clone()),
                        Some(nodes[i * 2 + 1].clone()),
                    )));
                }
            }
            len /= 2;
        }
        WinnerTree {
            head: Some(nodes[0].clone()),
        }
    }

    fn get_winner(&self) -> Option<i64> {
        if let Some(node) = &self.head {
            return Some(node.borrow().value);
        } else {
            return None;
        }
    }

    fn remove_winner_and_replay(&mut self) -> Option<i64> {
        let winner = self.get_winner();
        let mut cur;

        if let Some(node) = &self.head {
            cur = node.clone();
        } else {
            return None;
        }
        let mut stack: Vec<Rc<RefCell<TreeNode>>> = vec![];
        loop {
            let mut next = None;
            {
                let mut cur_borrow = cur.borrow_mut();
                if let Some(left) = cur_borrow.left.clone() {
                    if cur_borrow.value == left.borrow().value {
                        if left.borrow().left.is_none() && left.borrow().right.is_none() {
                            cur_borrow.left = None;
                            if let Some(right) = cur_borrow.right.clone() {
                                cur_borrow.value = right.borrow().value;
                            }
                            stack.push(cur.clone());
                            break;
                        } else {
                            next = Some(left);
                        }
                    }
                }
                if next.is_none() {
                    if let Some(right) = cur_borrow.right.clone() {
                        if cur_borrow.value == right.borrow().value {
                            if right.borrow().left.is_none() && right.borrow().right.is_none() {
                                cur_borrow.right = None;
                                if let Some(left) = cur_borrow.left.clone() {
                                    cur_borrow.value = left.borrow().value;
                                }
                                stack.push(cur.clone());
                                break;
                            } else {
                                next = Some(right);
                            }
                        }
                    }
                }
            }
            if let Some(next_node) = next {
                stack.push(cur);
                cur = next_node;
            }
        }

        loop {
            cur = stack[stack.len() - 1].clone();
            let cur_borrow = cur.borrow_mut();
            if cur_borrow.left.is_none() && cur_borrow.right.is_none() {
                if stack.len() == 1 {
                    self.head = None;
                } else {
                    let parent = stack[stack.len() - 2].clone();
                    let mut parent_borrow = parent.borrow_mut();
                    let mut found = false;
                    if let Some(left_child) = parent_borrow.left.clone() {
                        if Rc::ptr_eq(&left_child, &cur) {
                            parent_borrow.left = None;
                            found = true;
                        }
                    }
                    if !found {
                        if let Some(right_child) = parent_borrow.right.clone() {
                            if Rc::ptr_eq(&right_child, &cur) {
                                parent_borrow.right = None;
                                found = true;
                            }
                        }
                    }
                    if !found {
                        panic!("Inconsistent state");
                    }
                }
            } else {
                break;
            }
            drop(cur_borrow);
            stack.pop();
            if stack.is_empty() {
                break;
            }
        }

        while let Some(cur) = stack.pop() {
            let mut cur_borrow = cur.borrow_mut();
            match (cur_borrow.left.clone(), cur_borrow.right.clone()) {
                (Some(left), Some(right)) => {
                    cur_borrow.value = min(left.borrow().value, right.borrow().value);
                }
                (Some(left), None) => {
                    cur_borrow.value = left.borrow().value;
                }
                (None, Some(right)) => {
                    cur_borrow.value = right.borrow().value;
                }
                (None, None) => (),
            };
        }

        winner
    }
    pub fn remove_winner_and_replay_repeat(&mut self, n: usize) -> Vec<Option<i64>> {
        let mut winners: Vec<Option<i64>> = vec![];
        for _i in 0..n {
            let winner = self.remove_winner_and_replay();
            winners.push(winner);
        }
        winners
    }
}

struct LoserTree {}

impl LoserTree {}

fn level_order(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i64> {
    let mut result: Vec<i64> = Vec::new();
    let start;
    if let Some(node) = root {
        start = node;
    } else {
        return result;
    }
    let mut deq: VecDeque<Rc<RefCell<TreeNode>>> = VecDeque::new();
    deq.push_back(start.clone());
    while !deq.is_empty() {
        let node = deq.pop_front().unwrap();
        result.push(node.borrow().value);
        if let Some(left) = &node.borrow().left {
            deq.push_back(left.clone())
        };
        if let Some(right) = &node.borrow().right {
            deq.push_back(right.clone())
        };
    }
    result
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn initialize() {
        let values = [1, 2, 3, 4, 5, 6, 7, 8];
        let winner_tree = WinnerTree::initialize(values.to_vec());

        let actual_level_order_traversal = level_order(winner_tree.head.clone());

        let expected_level_order_traversal = vec![1, 1, 5, 1, 3, 5, 7, 1, 2, 3, 4, 5, 6, 7, 8];

        assert_eq!(expected_level_order_traversal, actual_level_order_traversal);
    }

    #[test]
    fn remove_winner_and_replay() {
        let values = [1, 2, 3, 4, 5, 6, 7, 8];
        let mut winner_tree = WinnerTree::initialize(values.to_vec());

        let actual_winners = winner_tree.remove_winner_and_replay_repeat(10);

        let expected_winners: Vec<Option<i64>> = [
            Some(1),
            Some(2),
            Some(3),
            Some(4),
            Some(5),
            Some(6),
            Some(7),
            Some(8),
            None,
            None,
        ]
        .to_vec();

        assert_eq!(expected_winners, actual_winners);
    }
}
