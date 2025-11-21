package com.swmansion.kmpliveactivity.sample

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString

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
    modifier = Modifier.fillMaxWidth(),
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
    modifier = Modifier.fillMaxWidth(),
    label = { Text(label) },
    placeholder = if (placeholder != null) ({ Text(placeholder) }) else null,
    prefix = if (prefix != null) ({ Text(prefix) }) else null,
    isError = hasError,
    singleLine = true,
  )
}
