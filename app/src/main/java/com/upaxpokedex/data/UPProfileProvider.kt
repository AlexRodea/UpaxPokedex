package com.upaxpokedex.data

import com.upaxpokedex.domain.models.UPProfile


class UPProfileProvider {
    fun getListOfProfiles(): List<UPProfile> =
        listOf(
            UPProfile(
                "Alexandra",
                "Rodea Chávez",
                "https://www.eleconomista.com.mx/__export/1678414747964/sites/eleconomista/img/2023/03/09/mujeres_alta_direccixn.jpg_1902800913.jpg"
            ),
            UPProfile(
                "Johan",
                "Alejandro Marquez",
                "https://st.depositphotos.com/1743476/1276/i/450/depositphotos_12767124-stock-photo-joyful-man-face.jpg"
            ),
            UPProfile(
                "Ray",
                "Luna",
                "https://media.revistagq.com/photos/63d385ff6343486b9fb8366f/16:9/w_2560%2Cc_limit/GettyImages-1436967466.jpg"
            ),
            UPProfile(
                "Ray",
                "Iniciales url vacía",
                ""
            ),
            UPProfile(
                "Ray",
                "Iniciales url invalida",
                "https://media.revistagq.com/photos/666.jpg"
            ),
            UPProfile(
                "?Ray",
                "NombreInvalido y errorLoad",
                "https://media.revistagq.com/photos/666.jpg"
            ),
            UPProfile(
                "Ray",
                "",
                ""
            ),
            UPProfile(
                "",
                "",
                "https://media.revistagq.com/photos/666.jpg"
            )
        )
}