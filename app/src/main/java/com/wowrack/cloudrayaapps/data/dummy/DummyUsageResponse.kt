package com.wowrack.cloudrayaapps.data.dummy

//import com.wowrack.cloudrayaapps.data.model.UsageData
//import com.wowrack.cloudrayaapps.data.model.UsageResponse
//
//fun getDummyUsageResponse(): UsageResponse {
//    val usageData = listOf(
//        UsageData(
//            cpuUsed = "3.83",
//            diskioRead = "0",
//            diskioWrite = "12",
//            memoryUsed = "1175385",
//            date = "2023-11-19",
//            hour = 23,
//            convertedDay = 20,
//            convertedHour = 6
//        ),
//        UsageData(
//            cpuUsed = "3.88",
//            diskioRead = "0",
//            diskioWrite = "11",
//            memoryUsed = "1175291",
//            date = "2023-11-19",
//            hour = 4,
//            convertedDay = 19,
//            convertedHour = 11
//        ),
//        UsageData(
//            cpuUsed = "3.82",
//            diskioRead = "0",
//            diskioWrite = "14",
//            memoryUsed = "1175403",
//            date = "2023-11-19",
//            hour = 5,
//            convertedDay = 19,
//            convertedHour = 12
//        ),
//        UsageData(
//            cpuUsed = "3.82",
//            diskioRead = "0",
//            diskioWrite = "5",
//            memoryUsed = "1175515",
//            date = "2023-11-19",
//            hour = 6,
//            convertedDay = 19,
//            convertedHour = 13
//        ),
//        UsageData(
//            cpuUsed = "3.85",
//            diskioRead = "0",
//            diskioWrite = "32",
//            memoryUsed = "1175455",
//            date = "2023-11-19",
//            hour = 7,
//            convertedDay = 19,
//            convertedHour = 14
//        ),
//        UsageData(
//            cpuUsed = "3.87",
//            diskioRead = "0",
//            diskioWrite = "39",
//            memoryUsed = "1175712",
//            date = "2023-11-19",
//            hour = 8,
//            convertedDay = 19,
//            convertedHour = 15
//        ),
//        UsageData(
//            cpuUsed = "3.86",
//            diskioRead = "0",
//            diskioWrite = "1",
//            memoryUsed = "1175557",
//            date = "2023-11-19",
//            hour = 9,
//            convertedDay = 19,
//            convertedHour = 16
//        ),
//        UsageData(
//            cpuUsed = "3.81",
//            diskioRead = "0",
//            diskioWrite = "2",
//            memoryUsed = "1175684",
//            date = "2023-11-19",
//            hour = 10,
//            convertedDay = 19,
//            convertedHour = 17
//        ),
//        UsageData(
//            cpuUsed = "3.71",
//            diskioRead = "0",
//            diskioWrite = "0",
//            memoryUsed = "1175701",
//            date = "2023-11-19",
//            hour = 11,
//            convertedDay = 19,
//            convertedHour = 18
//        ),
//        UsageData(
//            cpuUsed = "3.74",
//            diskioRead = "0",
//            diskioWrite = "0",
//            memoryUsed = "1175701",
//            date = "2023-11-19",
//            hour = 12,
//            convertedDay = 19,
//            convertedHour = 19
//        ),
//        UsageData(
//            cpuUsed = "3.84",
//            diskioRead = "0",
//            diskioWrite = "1",
//            memoryUsed = "1175565",
//            date = "2023-11-19",
//            hour = 13,
//            convertedDay = 19,
//            convertedHour = 20
//        ),
//        UsageData(
//            cpuUsed = "3.84",
//            diskioRead = "0",
//            diskioWrite = "0",
//            memoryUsed = "1175583",
//            date = "2023-11-19",
//            hour = 14,
//            convertedDay = 19,
//            convertedHour = 21
//        ),
//        UsageData(
//            cpuUsed = "3.81",
//            diskioRead = "0",
//            diskioWrite = "1",
//            memoryUsed = "1175608",
//            date = "2023-11-19",
//            hour = 15,
//            convertedDay = 19,
//            convertedHour = 22
//        ),
//        UsageData(
//            cpuUsed = "3.82",
//            diskioRead = "0",
//            diskioWrite = "2",
//            memoryUsed = "1175547",
//            date = "2023-11-19",
//            hour = 16,
//            convertedDay = 19,
//            convertedHour = 23
//        ),
//        UsageData(
//            cpuUsed = "3.87",
//            diskioRead = "0",
//            diskioWrite = "20",
//            memoryUsed = "1175306",
//            date = "2023-11-19",
//            hour = 17,
//            convertedDay = 20,
//            convertedHour = 0
//        ),
//        UsageData(
//            cpuUsed = "3.86",
//            diskioRead = "0",
//            diskioWrite = "0",
//            memoryUsed = "1175572",
//            date = "2023-11-19",
//            hour = 18,
//            convertedDay = 20,
//            convertedHour = 1
//        ),
//        UsageData(
//            cpuUsed = "3.86",
//            diskioRead = "0",
//            diskioWrite = "1",
//            memoryUsed = "1175680",
//            date = "2023-11-19",
//            hour = 19,
//            convertedDay = 20,
//            convertedHour = 2
//        ),
//        UsageData(
//            cpuUsed = "3.84",
//            diskioRead = "0",
//            diskioWrite = "0",
//            memoryUsed = "1175925",
//            date = "2023-11-19",
//            hour = 20,
//            convertedDay = 20,
//            convertedHour = 3
//        ),
//        UsageData(
//            cpuUsed = "3.85",
//            diskioRead = "0",
//            diskioWrite = "0",
//            memoryUsed = "1175821",
//            date = "2023-11-19",
//            hour = 21,
//            convertedDay = 20,
//            convertedHour = 4
//        ),
//        UsageData(
//            cpuUsed = "3.87",
//            diskioRead = "0",
//            diskioWrite = "1",
//            memoryUsed = "1175836",
//            date = "2023-11-19",
//            hour = 22,
//            convertedDay = 20,
//            convertedHour = 5
//        ),
//        UsageData(
//            cpuUsed = "3.84",
//            diskioRead = "0",
//            diskioWrite = "0",
//            memoryUsed = "1175862",
//            date = "2023-11-20",
//            hour = 0,
//            convertedDay = 20,
//            convertedHour = 7
//        ),
//        UsageData(
//            cpuUsed = "3.81",
//            diskioRead = "0",
//            diskioWrite = "0",
//            memoryUsed = "1175909",
//            date = "2023-11-20",
//            hour = 1,
//            convertedDay = 20,
//            convertedHour = 8
//        ),
//        UsageData(
//            cpuUsed = "3.82",
//            diskioRead = "0",
//            diskioWrite = "39",
//            memoryUsed = "1176143",
//            date = "2023-11-20",
//            hour = 2,
//            convertedDay = 20,
//            convertedHour = 9
//        ),
//    )
//
//    return UsageResponse(
//        code = 200,
//        data = usageData,
//        message = "Success get data Usage VM."
//    )
//}