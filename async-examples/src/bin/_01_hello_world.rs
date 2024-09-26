use futures::executor::block_on;

async fn hello_world() {
    println!("hello world!");
}

fn main() {
    let future = hello_world();
    // Blocks the current thread till completion of the Future.
    block_on(future);
}
