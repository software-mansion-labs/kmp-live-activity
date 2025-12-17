package com.swmansion.kmpliveactivity.sample

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp

@Composable
fun TextField(
  value: String,
  onValueChange: (String) -> Unit,
  label: String,
  placeholder: String? = null,
  prefix: String? = null,
  hasError: Boolean = false,
) {
  TextField(
    value = value,
    onValueChange = onValueChange,
    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
    label = { Text(label) },
    placeholder = if (placeholder != null) ({ Text(placeholder) }) else null,
    prefix = if (prefix != null) ({ Text(prefix) }) else null,
    isError = hasError,
    singleLine = true,
  )
}

@Composable
fun TextField(
  value: String,
  onValueChange: (String) -> Unit,
  label: AnnotatedString,
  placeholder: String? = null,
  prefix: String? = null,
  hasError: Boolean = false,
) {
  TextField(
    value = value,
    onValueChange = onValueChange,
    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
    label = { Text(label) },
    placeholder = if (placeholder != null) ({ Text(placeholder) }) else null,
    prefix = if (prefix != null) ({ Text(prefix) }) else null,
    isError = hasError,
    singleLine = true,
  )
}
