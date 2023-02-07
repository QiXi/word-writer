package qixi.wordwriter

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.lerp
import androidx.compose.ui.unit.sp

private val styleTransparent = SpanStyle(color = Color.Transparent, fontSize = 8.sp)
private val styleNormal = SpanStyle(color = Color.Black, fontSize = 16.sp)

@Composable
fun TypewriterState(
    writer: Writer = TypewriterData(),
    textState: State<String>,
    startStyle: SpanStyle = styleTransparent,
    targetStyle: SpanStyle = styleNormal,
    animationSpec: AnimationSpec<Float> = tween(durationMillis = 150, easing = FastOutSlowInEasing),
    finishedListener: (() -> Unit)? = null
): AnnotatedString {
    return Typewriter(writer = writer, text = textState.value, startStyle, targetStyle, animationSpec, finishedListener)
}

@Composable
fun Typewriter(
    writer: Writer = TypewriterData(),
    text: String,
    startStyle: SpanStyle = styleTransparent,
    targetStyle: SpanStyle = styleNormal,
    animationSpec: AnimationSpec<Float> = tween(durationMillis = 150, easing = FastOutSlowInEasing),
    finishedListener: (() -> Unit)? = null
): AnnotatedString {

    val writerDate = remember { writer }
    val animation = remember { Animatable(0f) }
    LaunchedEffect(text) {
        writerDate.reset(text)
        while (writerDate.hasNext()) {
            writerDate.next()
            animation.snapTo(0f)
            animation.animateTo(1f, animationSpec)
        }
        finishedListener?.invoke()
    }
    val builder = AnnotatedString.Builder(capacity = 128)
    builder.append(text)
    var start = writerDate.startIndex
    var end = writerDate.endIndex
    if (builder.length < writerDate.endIndex) {
        start = 0
        end = builder.length
    } else {
        builder.addStyle(targetStyle, 0, start)
    }
    val spanStyleState = lerp(startStyle, targetStyle, animation.value)
    builder.addStyle(spanStyleState, start, end)

    return builder.toAnnotatedString()
}