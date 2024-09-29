@Composable
fun MyApp() {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Material Design App") }
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { /* TODO */ }) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }
            }
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                ContentWithAnimations()
            }
        }
    }
}

@Composable
fun ContentWithAnimations() {
    var expanded by remember { mutableStateOf(false) }
    val size by animateDpAsState(targetValue = if (expanded) 200.dp else 100.dp)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ElevatedCardExample()
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { expanded = !expanded },
            modifier = Modifier.size(size)
        ) {
            Text("Animate Size")
        }
    }
}
