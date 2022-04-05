package com.example.retoinstagram

class PostProvider {

    companion object{

        val allPostList = listOf<Post>(
            Post(
                "https://upload.wikimedia.org/wikipedia/commons/3/32/Googleplex_HQ_%28cropped%29.jpg",
                "Foto de las instalaciones de Google",
                "Cali, Colombia"
            ),
            Post(
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/f330b20efbbdd1d3dbb2ce2cdbfca09706e229998381d1968aacc8777d701b07._SX1080_.jpg",
                "Este podria ser el fin de hombre araña",
                "Nwe York City, USA"
            ),
            Post(
                "https://www.apple.com/v/macbook-pro-14-and-16/b/images/meta/macbook-pro-14-and-16_overview__fz0lron5xyuu_og.png?202203301129",
                "Nuevo modelo de la macbook pro modelo 2022",
                "California, USA"
            )
        )
    }
}