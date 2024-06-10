PSUDIOCODE FOR MY weather app
start
Declare variables
	private lateinit var morningScreenTime: EditText
	    private lateinit var afternoonScreenTime: EditText
	    private lateinit var saveButton: Button
	    private val daysData = Array(3) { IntArray(2) }
	    private var currentDay = 0
Declare variables onCreate
	morningWeather = findViewById(R.id.morningWeather)
	        afternoonWeather = findViewById(R.id.afternoonWeather)
	        saveButton = findViewById(R.id.saveButton)
//give button instruction to go to next page and implement logic for editText to link with the following activity
	saveButton.setOnClickListener {
            val morningTime = morningWeather.text.toString().toIntOrNull() ?: 0
            val afternoonTime = afternoonWeather.text.toString().toIntOrNull() ?: 0
            daysData[currentDay][0] = morningTime
            daysData[currentDay][1] = afternoonTime
            currentDay++

//implement IF/Else statement
	if (currentDay >= daysData.size) {
                val intent = Intent(this, DetailedActivity::class.java).apply {
                    putExtra("DAYS_DATA", daysData)
                }
                startActivity(intent)
            } else {
                morningWeather.text.clear()
                afternoonWeather.text.clear()
            }
        }

//once in DetailedActivity declare variables
	  private lateinit var screenWeatherDisplay: TextView
Declare onCreate
	screenWeatherDisplay = findViewById(R.id.screenWeatherDisplay)

        val daysData = intent.getSerializableExtra("DAYS_DATA") as Array<IntArray>
        val stringBuilder = StringBuilder()
        var totalMorningDegrees = 0
        var totalAfternoonDegrees = 0
        var dayIndex = 0

//use arrays to store, manage weekly weather and implement While loop

	while (dayIndex < daysData.size) {
            val morningTime = daysData[dayIndex][0]
            val afternoonTime = daysData[dayIndex][1]
            totalMorningDegrees += morningTime
            totalAfternoonDegrees += afternoonTime

            stringBuilder.append("Day ${dayIndex + 1}:\n")
            stringBuilder.append("  Morning Weather: $morningTime Degrees\n")
            stringBuilder.append("  Afternoon Weather: $afternoonTime Degrees\n\n")
            dayIndex++
        }
//use arrays to group and calculate the average weather

	val averageMorningTime = totalMorningDegrees / daysData.size
        val averageAfternoonTime = totalAfternoonDegrees / daysData.size

        stringBuilder.append("Average Morning Weather: $averageMorningTime Degrees\n")
        stringBuilder.append("Average Afternoon Weather: $averageAfternoonTime Degrees\n")

        screenWeatherDisplay.text = stringBuilder.toString()

End
