use futures::executor::block_on;

struct Song {}

async fn learn_song() -> Song {
    println!("learning song");
    Song {}
}

async fn sing_song(_song: Song) {
    println!("singing song");
}

async fn dance() {
    println!("dancing")
}

async fn learn_and_sing() {
    // Using await here lets learning dancing parallely on the same thread.
    let song = learn_song().await;
    sing_song(song).await;
}

fn blocking_learn() {
    let song = block_on(learn_song());
    block_on(sing_song(song));
    block_on(dance());
}

async fn parallel_learn() {
    let f1 = learn_and_sing();
    let f2 = dance();
    futures::join!(f1, f2);
}

fn parallel_learn_main() {
    block_on(parallel_learn());
}

fn main() {
    blocking_learn();
    parallel_learn_main();
}
