package com.example.assistant

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AssistantScreen(viewModel: AssistantViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F0D13))
            .clickable(interactionSource = null, indication = null) {
                // Click anywhere on background to toggle for demo
                viewModel.toggleListening()
            }
    ) {
        // Atmospheric Background Glows
        Box(
            modifier = Modifier
                .fillMaxSize()
                .blur(60.dp)
                .drawBehind {
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = listOf(Color(0xFF6750A4), Color.Transparent),
                            center = Offset(size.width * 0.5f, size.height * 0.3f),
                            radius = size.width * 0.8f
                        ),
                        alpha = 0.2f
                    )
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = listOf(Color(0xFFD0BCFF), Color.Transparent),
                            center = Offset(size.width * 0.8f, size.height * 0.8f),
                            radius = size.width * 0.6f
                        ),
                        alpha = 0.2f
                    )
                }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
            Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))

            // Status Bar Overlay (Mock inside app)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "12:45",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF4ADE80))
                            .shadow(8.dp, CircleShape, ambientColor = Color(0xFF4ADE80), spotColor = Color(0xFF4ADE80))
                    )
                    Text(
                        text = "SECURE PROXY ACTIVE",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 2.sp,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                    )
                }
            }

            // Top Header Area
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Row {
                        Text(
                            text = "Aura ",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Light,
                            color = Color.White
                        )
                        Text(
                            text = "OS",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFFD0BCFF)
                        )
                    }
                    Text(
                        text = "SYSTEM V4.2.0 • FOREGROUND SERVICE",
                        fontSize = 10.sp,
                        letterSpacing = 2.sp,
                        color = Color(0xFF94A3B8)
                    )
                }
                
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.05f))
                        .border(1.dp, Color.White.copy(alpha = 0.1f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .border(2.dp, Color(0xFFD0BCFF), CircleShape)
                    )
                }
            }

            // Central Immersive Visualizer (AI Brain)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    
                    Box(contentAlignment = Alignment.Center) {
                        // Outer Glow
                        val infiniteTransition = rememberInfiniteTransition()
                        val scale by infiniteTransition.animateFloat(
                            initialValue = 1f,
                            targetValue = 1.1f,
                            animationSpec = infiniteRepeatable(
                                animation = tween(1500, easing = FastOutSlowInEasing),
                                repeatMode = RepeatMode.Reverse
                            )
                        )

                        Box(
                            modifier = Modifier
                                .size(256.dp)
                                .scale(if (state.isListening) scale else 1f)
                                .blur(48.dp)
                                .background(Color(0xFFD0BCFF).copy(alpha = 0.1f), CircleShape)
                        )
                        
                        // The Orb
                        Box(
                            modifier = Modifier
                                .size(192.dp)
                                .shadow(60.dp, CircleShape, spotColor = Color(0xFF6750A4).copy(alpha = 0.4f))
                                .clip(CircleShape)
                                .background(
                                    Brush.linearGradient(
                                        colors = listOf(Color(0xFF4F378B), Color(0xFF21005D)),
                                        start = Offset(0f, 0f),
                                        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                                    )
                                )
                                .border(1.dp, Color.White.copy(alpha = 0.1f), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize(0.9f)
                                    .border(1.dp, Color.White.copy(alpha = 0.05f), CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                // Sound Waves Visualization
                                Row(
                                    modifier = Modifier.height(48.dp),
                                    verticalAlignment = Alignment.Bottom,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    val heights = if (state.isListening) listOf(32, 48, 40, 56, 24, 40) else listOf(8, 12, 10, 14, 6, 10)
                                    heights.forEachIndexed { index, h ->
                                        Box(
                                            modifier = Modifier
                                                .width(4.dp)
                                                .height(h.dp)
                                                .clip(CircleShape)
                                                .background(Color(0xFFD0BCFF).copy(alpha = if (index == 0) 0.4f else 1f))
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // Real-time STT Stream
                    Spacer(modifier = Modifier.height(48.dp))
                    Box(modifier = Modifier.padding(horizontal = 32.dp)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = if (state.transcription.isNotEmpty()) "\"${state.transcription}\"" else "\"Listening...\"",
                                color = Color(0xFF94A3B8),
                                fontSize = 14.sp,
                                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Box(
                                modifier = Modifier
                                    .height(2.dp)
                                    .width(64.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFD0BCFF).copy(alpha = 0.5f))
                            )
                        }
                    }
                }
            }

            // System State / Intent Deck
            if (state.lastIntent != null) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .clip(RoundedCornerShape(32.dp))
                        .background(Color.White.copy(alpha = 0.05f))
                        .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(32.dp))
                        .padding(20.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        
                        // Active Intent Display
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Column {
                                Text(
                                    text = "DETECTED INTENT",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 0.sp,
                                    color = Color(0xFFD0BCFF)
                                )
                                Text(
                                    text = state.lastIntent!!.intentDescription.take(25) + "...", // Trimmed for UI match "Schedule + Communication"
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color(0xFFD0BCFF).copy(alpha = 0.2f))
                                    .padding(horizontal = 12.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = "${(state.lastIntent!!.confidence * 100)}% Confidence",
                                    color = Color(0xFFD0BCFF),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        // Tool Execution Status
                        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            ToolExecutionCard(toolName = state.lastIntent!!.action, color = Color(0xFF60A5FA))
                            // Example second tool from HTML
                            ToolExecutionCard(toolName = "PhoneCallTool", color = Color(0xFF4ADE80))
                        }

                        // Response Context
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Row(horizontalArrangement = Arrangement.spacedBy((-8).dp)) {
                                Box(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFF334155))
                                        .border(1.dp, Color(0xFF0F172A), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("M", fontSize = 10.sp, color = Color.White)
                                }
                                Box(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFD0BCFF))
                                        .border(1.dp, Color(0xFF0F172A), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("AI", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
                                }
                            }
                            Text(
                                text = "Validating contact availability through Secure Proxy...",
                                fontSize = 11.sp,
                                color = Color(0xFFCBD5E1)
                            )
                        }
                    }
                }
            } else {
                Spacer(modifier = Modifier.height(200.dp)) // Placeholder space
            }
        }
    }
}

@Composable
fun RowScope.ToolExecutionCard(toolName: String, color: Color) {
    Box(
        modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White.copy(alpha = 0.05f))
            .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(16.dp))
            .padding(12.dp)
    ) {
        Column {
            Text(
                text = "TOOL CALLING",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF64748B),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(color)
                )
                Text(
                    text = toolName,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        }
    }
}

