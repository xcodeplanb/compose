/*
* Converted using https://composables.com/svgtocompose
*/

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Ic_player_next_episode_enable: ImageVector
	get() {
		if (_Ic_player_next_episode_enable != null) {
			return _Ic_player_next_episode_enable!!
		}
		_Ic_player_next_episode_enable = ImageVector.Builder(
            name = "Ic_player_next_episode_theme",
            defaultWidth = 25.dp,
            defaultHeight = 30.dp,
            viewportWidth = 25f,
            viewportHeight = 30f
        ).apply {
			path(
    			fill = SolidColor(Color(0xFFFFFFFF)),
    			fillAlpha = 1.0f,
    			stroke = null,
    			strokeAlpha = 1.0f,
    			strokeLineWidth = 1.0f,
    			strokeLineCap = StrokeCap.Butt,
    			strokeLineJoin = StrokeJoin.Miter,
    			strokeLineMiter = 1.0f,
    			pathFillType = PathFillType.EvenOdd
			) {
				moveTo(24.989f, 1.51f)
				curveToRelative(00f, -0.8270f, -0.6750f, -1.4980f, -1.5070f, -1.4980f)
				curveToRelative(-0.8330f, 00f, -1.5080f, 0.6710f, -1.5080f, 1.4980f)
				verticalLineToRelative(11.811f)
				lineTo(3.153f, 0.354f)
				curveTo(2.810f, 0.1180f, 2.410f, -0.0010f, 2.0080f, -0.0010f)
				curveToRelative(-0.3190f, 00f, -0.6390f, 0.0750f, -0.9320f, 0.2280f)
				curveTo(0.4140f, 0.5720f, -0.0010f, 1.2540f, -0.0010f, 1.9970f)
				verticalLineToRelative(26.005f)
				curveToRelative(00f, 0.7430f, 0.4150f, 1.4250f, 1.0770f, 1.770f)
				curveToRelative(0.2930f, 0.1530f, 0.6130f, 0.2280f, 0.9320f, 0.2280f)
				curveToRelative(0.4020f, 00f, 0.8020f, -0.120f, 1.1450f, -0.3560f)
				lineToRelative(18.821f, -12.966f)
				lineToRelative(0.001f, 11.81f)
				curveToRelative(00f, 0.8280f, 0.6740f, 1.4990f, 1.5070f, 1.4990f)
				curveToRelative(0.8320f, 00f, 1.5070f, -0.6710f, 1.5070f, -1.4990f)
				verticalLineTo(1.51f)
				close()
			}
		}.build()
		return _Ic_player_next_episode_enable!!
	}

private var _Ic_player_next_episode_enable: ImageVector? = null
