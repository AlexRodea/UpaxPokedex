package com.upaxpokedex.ui.profile

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.upaxpokedex.R
import com.upaxpokedex.domain.models.UPProfile
import com.upaxpokedex.ui.theme.UPGreen
import com.upaxpokedex.ui.theme.UPLightGreen
import com.upaxpokedex.utils.UPUtils
import com.upaxpokedex.utils.isStartWithAlphabet
import com.upaxpokedex.utils.isUrlInvalid
import kotlin.math.roundToInt

@Composable
fun ProfileScreen(
    listOfProfiles: List<UPProfile>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val screenWidth = with(LocalDensity.current) {
            LocalContext.current.resources.displayMetrics.widthPixels / density
        }
        val itemWidth = (screenWidth * 0.3).roundToInt().dp
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(listOfProfiles) {
                ProfileShape(name = it.name, lastname = it.lastname, photo = it.photo, screenWidth = itemWidth)
                Text(text = "${it.name} ${it.lastname}")
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProfileShape(
    modifier: Modifier = Modifier,
    name: String,
    lastname: String,
    photo: String,
    screenWidth: Dp,
    hasPhoto: Boolean = false
) {
    Box(modifier = modifier){
        ProfileInitials(screenWidth = screenWidth, name = name, lastname = lastname, hasPhoto = hasPhoto)

        if (!photo.isUrlInvalid()) {
            GlideImage(
                model = photo,
                contentDescription = null,
                modifier = Modifier
                    .width(screenWidth)
                    .height(screenWidth)
            ) {
                it.centerCrop()
                    .circleCrop()
                    .error(
                        if (!name.isStartWithAlphabet()) {
                            Log.e("Alex", "alphabet? ${name.isStartWithAlphabet()}")
                            R.drawable.ic_launcher_foreground
                        } else {
                            null
                        }
                    )

            }
        }
    }
}

@Composable
fun ProfileInitials(
    screenWidth: Dp,
    name: String,
    lastname: String,
    hasPhoto: Boolean = true
) {
    Box(
        modifier = Modifier
            .width(screenWidth)
            .height(screenWidth)
            .border(BorderStroke(3.dp, UPGreen), shape = CircleShape)
            .background(UPLightGreen, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        if (name.isNotBlank() && name.isStartWithAlphabet() && !hasPhoto) {
            Text(
                text = UPUtils.getNameInitials(name, lastname),
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = UPGreen
            )
        }
    }
}