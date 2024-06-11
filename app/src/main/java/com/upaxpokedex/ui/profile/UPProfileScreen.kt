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
                ProfileShape(profile = it, itemWidth)
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProfileShape(
    profile: UPProfile,
    screenWidth: Dp
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        ProfileInitials(screenWidth = screenWidth, profile = profile)

        if (!profile.photo.isUrlInvalid()) {
            GlideImage(
                model = profile.photo,
                contentDescription = null,
                modifier = Modifier
                    .width(screenWidth)
                    .height(screenWidth)
            ) {
                it.centerCrop()
                    .circleCrop()
                    .error(
                        if (!profile.name.isStartWithAlphabet()) {
                            Log.e("Alex", "alphabet? ${profile.name.isStartWithAlphabet()}")
                            R.drawable.ic_launcher_foreground
                        } else {
                            null
                        }
                    )

            }
        }
    }

    Text(text = profile.name + " " + profile.lastname)
}

@Composable
fun ProfileInitials(
    screenWidth: Dp,
    profile: UPProfile
) {
    Log.e("Alex valid", "isUrlInvalid -> ${profile.name}")
    Box(
        modifier = Modifier
            .width(screenWidth)
            .height(screenWidth)
            .border(BorderStroke(3.dp, UPGreen), shape = CircleShape)
            .background(UPLightGreen, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        if (profile.name.isNotBlank() && profile.name.isStartWithAlphabet()) {
            Text(
                text = UPUtils.getNameInitials(profile.name, profile.lastname),
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = UPGreen
            )
        }
    }
}