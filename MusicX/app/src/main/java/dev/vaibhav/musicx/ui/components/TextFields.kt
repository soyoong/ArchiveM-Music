package dev.vaibhav.musicx.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.Placeholder
import dev.vaibhav.musicx.R
import dev.vaibhav.musicx.ui.theme.MusicXTheme
import dev.vaibhav.musicx.ui.utils.SEARCH_BAR_CLOSE_TAG
import dev.vaibhav.musicx.ui.utils.SEARCH_BAR_TAG
import dev.vaibhav.musicx.utils.Define

@ExperimentalComposeUiApi
@Composable
fun SearchBar(
    searchQuery: String,
    modifier: Modifier = Modifier,
    onSearchQueryChanged: (String) -> Unit
) {
    val contentColor = MaterialTheme.colors.onSecondary
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colors.surface,
        contentColor = contentColor,
        elevation = 4.dp
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChanged,
            modifier = Modifier
                .fillMaxWidth()
                .testTag(SEARCH_BAR_TAG)
                .focusRequester(focusRequester),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                focusManager.clearFocus()
                keyboardController?.hide()
            }),
            textStyle = MaterialTheme.typography.subtitle1.copy(color = contentColor),
            singleLine = true,
            maxLines = 1,
            placeholder = {
                          Text(
                              text = "Search here..",
                              modifier = Modifier,
                              color = Color.Gray
                          )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    modifier = Modifier.padding(start = 8.dp),
                    contentDescription = stringResource(R.string.search_here)
                )
            },
            trailingIcon = {
                if (searchQuery.isNotBlank() && searchQuery.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "Close",
                        modifier = Modifier
                            .testTag(SEARCH_BAR_CLOSE_TAG)
                            .clickable {
                                onSearchQueryChanged("")
                                focusManager.clearFocus()
                            }
                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )
    }
}

@ExperimentalComposeUiApi
@Composable
fun AuthTextFiled(
    text: String,
    type: Define.TextFieldType,
    placeholder: String,
    painter: Painter,
    modifier: Modifier,
    onValueChange: (String) -> Unit
) {
    val contentColor = MaterialTheme.colors.secondary
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colors.surface,
        contentColor = contentColor,
        elevation = 4.dp
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .testTag(SEARCH_BAR_TAG)
                .focusRequester(focusRequester),
            keyboardOptions = KeyboardOptions(
                keyboardType = if (type == Define.TextFieldType.Email) KeyboardType.Email else if (type == Define.TextFieldType.Password) KeyboardType.Password else if (type == Define.TextFieldType.PhoneNumber) KeyboardType.Phone else KeyboardType.Text,
                imeAction = ImeAction.Default
            ),
            keyboardActions = KeyboardActions(onSearch = {
                focusManager.clearFocus()
                keyboardController?.hide()
            }),
            textStyle = MaterialTheme.typography.subtitle1.copy(color = contentColor),
            singleLine = true,
            maxLines = 1,
            placeholder = {
                Text(
                    text = placeholder,
                    modifier = Modifier,
                    color = Color.Gray
                )
            },
            leadingIcon = {
                Icon(
                    painter = painter,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .height(24.dp)
                        .width(24.dp),
                    contentDescription = stringResource(R.string.search_here)
                )
            },
            trailingIcon = {
                if (text.isNotBlank() && text.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "Close",
                        modifier = Modifier
                            .testTag(SEARCH_BAR_CLOSE_TAG)
                            .clickable {
                                onValueChange("")
                                focusManager.clearFocus()
                            }
                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )
    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    MusicXTheme {
        SearchBar(
            searchQuery = "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            onSearchQueryChanged = {}
        )
    }
}

@ExperimentalComposeUiApi
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SearchBarPreviewDark() {
    MusicXTheme {
        var query by remember { mutableStateOf("In general, most components..") }
        Column {
            SearchBar(
                searchQuery = query,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                onSearchQueryChanged = { query = it }
            )

            AuthTextFiled(
                text = query,
                type = Define.TextFieldType.Email,
                placeholder = "Email",
                painter = painterResource(id = R.drawable.ic_email),
                modifier = Modifier,
                onValueChange = {
                    query = it
                })
        }
    }
}
