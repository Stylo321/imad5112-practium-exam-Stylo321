[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/nGuRs7wl)

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

![image](https://github.com/IIEVCPMB/imad5112-practicum-exam-Stylo321/assets/165194260/dc2ce275-af97-4779-b601-84649669568f)
TESTING IS DONE AND WORKS.
![Screenshot (9)](https://github.com/IIEVCPMB/imad5112-practicum-exam-Stylo321/assets/165194260/6b9a7c36-3ade-4d05-9812-a3b5884bb68d)
splash SCREEN...PRESS"next"
![Screenshot (11)](https://github.com/IIEVCPMB/imad5112-practicum-exam-Stylo321/assets/165194260/e5fc71bf-f316-46c5-93c8-c28effc4c1aa)
aCTIVITY MAIN PRESS "SUBMIT" 

![Screenshot (12)](https://github.com/IIEVCPMB/imad5112-practicum-exam-Stylo321/assets/165194260/7655b1cc-ab99-4707-9d2a-8be78e9f48b6)
DetailedView this activity calculates the average and collects all the data and stroes them in parrallel arrays and also uses loops.
