object Modules {
    const val app = ":app"
    const val data = ":data"
    const val domain = ":domain"
    const val common = ":common"

    object Features {
        private const val base = ":feature"

        const val main = "${base}:main"
        const val home = "${base}:home"
        const val fav = "${base}:fav"
        const val escortRegister = "${base}:escortregister"
        const val escort = "${base}:escort"
        const val search = "${base}:search"
    }
}