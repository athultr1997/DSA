use crate::tournament_tree::WinnerTree;

enum Sort {
    TournamentSort(TournamentSort),
}

struct TournamentSort {}

impl TournamentSort {
    fn new() -> Self {
        TournamentSort {}
    }

    fn sort(&self, values: Vec<i64>) -> Vec<i64> {
        let len = values.len();
        let mut winner_tree = WinnerTree::initialize(values);
        let sorted_values = winner_tree.remove_winner_and_replay_repeat(len);
        sorted_values.into_iter().flatten().collect()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn sort() {
        let tournament_sort = TournamentSort::new();
        let values = [4, 1, 3, 2, 5, 8, 7, 6].to_vec();

        let actual_sorted_values = tournament_sort.sort(values);

        let expected_sorted_values = [1, 2, 3, 4, 5, 6, 7, 8].to_vec();

        assert_eq!(actual_sorted_values, expected_sorted_values);
    }
}
