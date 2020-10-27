fun main() {
    val original = Post(
        1,
        1,
        1,
        1234,
        "Hello",
        2,
        2,
        false,
        4,
        "5",
        1,
        3,
        4,
        "newType",
        5,
        true,
        true,
        true,
        true,
        true,
        true,
        4
    )

    val newPost = original.copy(text = "Hello Everyone!")

    WallService.add(original)
    WallService.update(newPost)

    val result = WallService.add(original).id

    print(result)

}