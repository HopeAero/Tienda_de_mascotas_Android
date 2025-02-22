package com.hopeaero.tiendademascotas

data class Pet(val id: Int, val name: String, val description: String, val animal: String,
               val race: String, val age: String, val imageResources: List<String>,
                val video: Int? = null)

val dogs = listOf(
    Pet(1, "Max", "Un perro juguetón y amigable",
        "Perro", "Labrador", "2 años",
        listOf("https://blog.mascotaysalud.com/wp-content/uploads/2019/09/LABRADOR-RETRIEVER-TUMBADO.jpg",
            "https://cdn0.uncomo.com/es/posts/4/5/1/como_cuidar_de_un_perro_labrador_5154_paso_6_600.jpg",
            "https://www.euroresidentes.com/fotos/postales_mascotas/perros/labrador/thumbnails/luk_mirando.jpg"),
        R.raw.labradorretriever
    ),
    Pet(2, "Bella", "Una perra cariñosa y protectora",
        "Perro", "Pastor Alemán", "4 años",
        listOf("https://www.zooplus.es/magazine/wp-content/uploads/2019/03/deutscher-schäferhund-768x511.jpg",
            "https://nfnatcane.es/blog/wp-content/uploads/2022/03/Pastor-Aleman-saltando.jpg",
            "https://content.elmueble.com/medio/2023/04/25/perro-pastor-aleman_2e008a4c_230425141056_1000x1500.jpg"),
        R.raw.pastoraleman
    ),
    Pet(3, "Rocky", "Un perro enérgico y aventurero",
        "Perro", "Bulldog", "3 años",
        listOf("https://www.dondemiveterinario.com/wp-content/uploads/2020/05/perro-bulldog-ingles.jpg",
            "https://blog.dogfydiet.com/wp-content/uploads/2023/05/Caracteristicas-bulldog-ingles.jpg",
            "https://cdn.britannica.com/08/234208-050-C9A21C4C/English-bulldog-dog.jpg"),
        R.raw.bulldog
    ),
)

val cats = listOf(
    Pet(4, "Luna", "Una gata tranquila y curiosa",
        "Gato", "Siamés", "1 año",
        listOf("https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-06Siamese201.jpg?itok=j9A2IvjN",
            "https://spazio.com.ar/wp-content/uploads/gatos-siameses.jpg",
            "https://www.hogarmania.com/archivos/202403/gato-siames-xl-1280x720x80xX.jpg"),
        R.raw.siames
    ),
    Pet(5, "Simba", "Un gato juguetón y mimoso",
        "Gato", "Persa", "2 años",
        listOf("https://cdn0.uncomo.com/es/posts/3/0/0/caracteristicas_fisicas_del_gato_persa_48003_1_600.jpg",
            "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-06Persian20Long20Hair.2.jpg?itok=qzNV_HuV",
            "https://www.clinicaraza.com/web/image/32394/Gato%20persa%20los%20reyes%20de%20la%20casa%20-%20URGENCIAS%20VETERINARIAS%2024%20HORAS%20-%20Clínica%20Raza?access_token=d477c3ca-edb7-4d1b-8b1c-7daf62fa8d9f"),
        R.raw.persa
    ),
    Pet(6, "Milo", "Un gato independiente y astuto",
        "Gato", "Maine Coon", "5 años",
        listOf("https://animalnatura.com/img/cms/que-come-gato-maine-coon.jpg",
            "https://www.mistermascotas.com.mx/cdn/shop/articles/1_ba30fe2b-1dd9-498b-948f-6ca59ca36dbc.jpg?v=1648170482",
            "https://animalnatura.com/img/cms/caracter-gatos-maine-coon.jpg"),
        R.raw.mainecoon
    )
)

val rabbits = listOf(
    Pet(7, "Coco", "Un conejo tranquilo y amistoso",
        "Conejo", "Holandés", "6 meses",
        listOf("https://cdn0.uncomo.com/es/posts/5/6/7/conejo_holandes_caracteristicas_y_cuidados_49765_orig.jpg",
            "https://wakyma.com/blog/wp-content/uploads/2021/03/conejo-holandes.jpg",
            "https://www.shutterstock.com/image-photo/young-dutch-rabbit-enjoying-nice-600nw-2371135945.jpg"),
        R.raw.holandes
    ),
    Pet(8, "Lola", "Una coneja curiosa y activa",
        "Conejo", "Mini Rex", "1 año",
        listOf("https://animalxop.com/cdn/shop/articles/OIP_-_2023-12-07T034327.998.jpg?v=1702093019",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4OV6zvu5X_81pZ4GbD1Oq5gPRLMroQ28g5aVAb7W4QwLzaCanojUL7lWXieBGsYMJu-k&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR8-lMViJzgkjWeUm6l1dGVwasm5v-7RvI9rp124hIb5mQo8t2WHB5FwFaKFCovVq1KYDU&usqp=CAU"),
        R.raw.minirex
    ),
    Pet(9, "Snowball", "Un conejo juguetón y cariñoso",
        "Conejo", "Angora", "2 años",
        listOf("https://i.pinimg.com/736x/df/ed/e5/dfede50ecb96cee1dd8e032f76c78edd.jpg",
            "https://cdn0.uncomo.com/es/posts/4/2/6/como_es_el_conejo_angora_21624_600_square.jpg",
            "https://billiken.lat/wp-content/uploads/2023/06/1b3796f554f5e84a7dcad58d79f19b0e-raising-rabbits-homesteading.jpg"),
        R.raw.angora
    )
)
