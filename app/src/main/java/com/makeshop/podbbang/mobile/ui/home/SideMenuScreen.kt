package com.makeshop.podbbang.mobile.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.makeshop.podbbang.mobile.R
import com.makeshop.podbbang.mobile.ui.theme.AppTheme
import com.makeshop.podbbang.mobile.ui.theme.Color1AFFFFFF
import com.makeshop.podbbang.mobile.ui.theme.Color1FA1EB
import com.makeshop.podbbang.mobile.ui.theme.Color666666

@Composable
fun SideMenuScreen() {
    SideMenuContent()
}

@Composable
fun SideMenuContent() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            LoginSection(true)
            NoticeSection(true)
            SubMenuSection()
            ServiceAndInfoSection()
            SidePolicySection()
            LogoutSection()
        }
}

@Composable
fun LoginSection(isLogin: Boolean) {
    // Conditional rendering based on login state
    if (isLogin) {
        NotLoggedInSection()
    } else {
        LoggedInSection()
    }
}

@Composable
fun NotLoggedInSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp, vertical = 16.dp
            )
            .background(
                color = Color1AFFFFFF, shape = RoundedCornerShape(8.dp)
            )
            .padding(vertical = 24.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.side_do_login),
            color = Color1FA1EB,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = stringResource(id = R.string.hamburger_login_intro),
            color = Color666666,
            fontSize = 14.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoggedInSection() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(
            horizontal = 16.dp, vertical = 16.dp
        )
        .clip(RoundedCornerShape(8.dp)) // Clip to rounded corners
        .background(colorResource(id = R.color.colorCC000000))
        .clickable { /* Handle click */ }
        .padding(vertical = 24.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically) {
        ProfileImage()
        Spacer(modifier = Modifier.width(14.dp))
        UserInfoSection()
        Spacer(modifier = Modifier.weight(1f)) // Push the arrow to the end
        Icon(
            painter = painterResource(id = R.drawable.ic_right_arrow_light_666_dark_bbb),
            contentDescription = null,
            modifier = Modifier.size(15.dp)
        )
    }
}

@Composable
fun ProfileImage() {
    ConstraintLayout(modifier = Modifier.size(46.dp)) {
        val (profileImage, overlayImage) = createRefs()
        AsyncImage(
            model = "profile_image_url", // Replace with your image URL
            contentDescription = null,
            modifier = Modifier
                .size(46.dp)
                .clip(CircleShape)
                .constrainAs(profileImage) {
                    centerTo(parent)
                },
            contentScale = ContentScale.Crop
        )
        Image(painter = painterResource(id = R.drawable.ic_right_arrow_light_666_dark_bbb),
            contentDescription = null,
            modifier = Modifier
                .size(20.dp)
                .constrainAs(overlayImage) {
                    bottom.linkTo(profileImage.bottom)
                    end.linkTo(profileImage.end)
                })
    }
}

@Composable
fun UserInfoSection() {
    Column {
        Text(
            text = "User Nickname", // Replace with actual user nickname
            color = colorResource(id = R.color.color1AFFFFFF), fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            Text(
                text = stringResource(id = R.string.my_cash),
                color = colorResource(id = R.color.color1AFFFFFF),
                fontSize = 12.sp
            )
            Text(
                text = ":", color = colorResource(id = R.color.color1AFFFFFF), fontSize = 12.sp
            )
            Text(
                text = "181,800", // Replace with actual user cash
                color = colorResource(id = R.color.color1AFFFFFF), fontSize = 14.sp
            )
        }
    }
}

@Composable
fun NoticeSection(isVisible: Boolean) {
    if (isVisible) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(vertical = 16.dp) // Adjust vertical padding as needed
                .clip(RoundedCornerShape(15.dp))
                .background(colorResource(id = R.color.color1AFFFFFF))
                .padding(vertical = 9.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_channel_notice_on),
                contentDescription = null,
                modifier = Modifier.size(12.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "가장 최근 올라온 공지사항입니다. 제목이 길 경우 말줄임표를 표시합니다.", // Replace with actual notice text
                color = colorResource(id = R.color.color1AFFFFFF),
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun SubMenuSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceAround, // Distribute items evenly
        verticalAlignment = Alignment.CenterVertically
    ) {
        SubMenuItem(
            icon = R.drawable.ic_side_menu_community_div,
            text = stringResource(id = R.string.community)
        )
        SubMenuItem(
            icon = R.drawable.ic_side_menu_musicpod_div,
            text = stringResource(id = R.string.music_pod)
        )
        SubMenuItem(
            icon = R.drawable.ic_side_menu_giftbox_div,
            text = stringResource(id = R.string.gift_box)
        )
        SubMenuItem(
            icon = R.drawable.ic_side_menu_charge_div, text = stringResource(id = R.string.charge)
        )
    }
}

@Composable
fun SubMenuItem(icon: Int, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = icon),
            tint = Color.Unspecified,
            contentDescription = null,
            modifier = Modifier
                .size(46.dp)
                .padding(top = 2.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = text, color = colorResource(id = R.color.light000000DarkFFFFFF), fontSize = 14.sp
        )
    }
}

@Composable
fun ServiceAndInfoSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        // My Service Section

        // Info Section
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        SectionHeader(text = stringResource(id = R.string.side_info_title))
        NavigationRow(
            items = listOf(NavigationItem(text = stringResource(id = R.string.notice)) { /* Handle click */ },
                NavigationItem(text = stringResource(id = R.string.frequently_asked_questions)) { /* Handle click */ })
        )
        NavigationRow(
            items = listOf(NavigationItem(text = stringResource(id = R.string.do_question)) { /* Handle click */ },
                NavigationItem(text = stringResource(id = R.string.event)) { /* Handle click */ }),
        )
        NavigationRow(
            items = listOf(NavigationItem(text = stringResource(id = R.string.advertising_center)) { /* Handle click */ }),
        )
    }
}

@Composable
fun SectionHeader(text: String) {
    Text(
        text = text,
        color = colorResource(id = R.color.light000000DarkFFFFFF),
        fontSize = 14.sp,
        modifier = Modifier.padding(vertical = 16.dp)
    )
}

@Composable
fun NavigationRow(items: List<NavigationItem>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
    ) {
        items.forEach { item ->
            item.Content(Modifier.weight(1F))
        }
    }
}

@Composable
fun SidePolicySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        // My Service Section

        // Info Section
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        SectionHeader(text = stringResource(id = R.string.side_policy_title))
        NavigationRow(
            items = listOf(NavigationItem(text = stringResource(id = R.string.terms_of_use)) { /* Handle click */ },
                NavigationItem(text = stringResource(id = R.string.privacy_policy)) { /* Handle click */ })
        )
        NavigationRow(
            items = listOf(
                NavigationItem(text = stringResource(id = R.string.youth_protection_policy)) { /* Handle click */ },
            )
        )
    }
}

@Composable
fun LogoutSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_logout),
            contentDescription = null,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(id = R.string.logout),
            color = colorResource(id = R.color.light777777Dark888888),
            fontSize = 14.sp
        )
    }
}

data class NavigationItem(val text: String, val onClick: () -> Unit) {
    @Composable
    fun Content(modifier: Modifier = Modifier) {
        Text(
            modifier = modifier,
            text = text,
            color = colorResource(id = R.color.light000000DarkFFFFFF),
            fontSize = 14.sp,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SideMenuScreenPreview() {

    AppTheme {
        SideMenuScreen()
    }
}