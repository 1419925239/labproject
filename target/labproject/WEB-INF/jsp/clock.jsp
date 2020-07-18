
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>



<head>

    <meta charset="UTF-8">

    <title></title>

    <style>

        body,

        html {

            margin: 0;

        }



        .location {

            position: relative;

            width: 300px;

            height: 100%;

            left: calc(50% - 150px);

        }



        .dial {

            width: 300px;

            height: 300px;

            margin: 0 auto;

            position: absolute;

            border-radius: 50%;

            overflow: hidden;

            background-color: rgba(153, 50, 204, 0.2);



            background-size: 100% 100%;

        }



        .bigdiv {

            width: 300px;

            height: 300px;

            margin: 0 auto;

            position: absolute;

            border-radius: 50%;

            overflow: hidden;

        }



        .bigdiv>div {

            position: absolute;

            left: 149px;

            border-radius: 50px;

        }



        .bigdiv1 {

            animation: moves 60s steps(60) infinite;

        }



        .bigdiv1 .secondHand {

            width: 2px;

            height: 125px;

            background-color: red;

            top: 25px;

            left: 149px;

        }



        .bigdiv2 {

            animation: moves 3600s steps(3600) infinite;

        }



        .bigdiv2 .minuteHand {

            width: 3px;

            height: 90px;

            background-color: green;

            top: 60px;

            left: 148px;

        }



        .bigdiv3 {

            animation: moves 216000s steps(216000) infinite;

        }



        .bigdiv3 .hourHand {

            width: 4px;

            height: 80px;

            background-color: orange;

            top: 70px;

            left: 149px;

            border-radius: 50px;

        }



        .bigdiv .center {

            top: 145px;

            left: 145px;

            width: 10px;

            height: 10px;

            background-color: black;

            z-index: 1;

        }



        @keyframes moves {

            from {

                transform: rotateZ(0deg);

            }

            to {

                transform: rotateZ(360deg);

            }

        }



        #dateshow {

            text-align: center;

        }

    </style>



</head>



<body style="overflow:auto">

<h1 id="dateshow"></h1>

<div class="location">

    <div class="dial"></div>

    <div class="bigdiv bigdiv1" id="secondHand">

        <div class="secondHand"></div>

    </div>

    <div class="bigdiv bigdiv2" id="minuteHand">

        <div class="minuteHand"></div>

    </div>

    <div class="bigdiv bigdiv3" id="hourHand">

        <div class="center"></div>

        <div class="hourHand"></div>

    </div>

</div>

<script>

    var dateshow = document.getElementById("dateshow");

    var clock = {

        weeks: ["一", "二", "三", "四", "五", "六", "日"],

        getDate: function() {

            date = new Date();

            year = date.getFullYear();

            month = date.getMonth() + 1;

            day = date.getDate();

            hours = date.getHours();

            minutes = date.getMinutes();

            seconds = date.getSeconds();

            week = date.getDay(); // 星期

            dateText = year + "年" + month + "月" + clock.format(day) + "日 " + " " +

                clock.format(hours) + ":" + clock.format(minutes) + ":" + clock.format(seconds);

            return dateText;

        },

        format: function(data) {

            if(data.toString().length == 1) {

                data = "0" + data;

            };

            return data;

        },

        formatnum: function(num) {

            return clock.weeks[num - 1];

        },

        showdate: function() {

            dateshow.innerText = clock.getDate();

        },

        go: function() {

            var secondHand = document.getElementById("secondHand");

            var minuteHand = document.getElementById("minuteHand");

            var hourHand = document.getElementById("hourHand");

            date = new Date();

            hours = date.getHours();

            minutes = date.getMinutes();

            seconds = date.getSeconds();

            var secondAngle = seconds;

            var minuteAngle = minutes * 60 + seconds;

            var hourAngle = (60 / 12) * ((hours % 12) * 3600 + minuteAngle);

            hourHand.style.cssText = "animation-delay: -" + hourAngle + "s";

            minuteHand.style.cssText = "animation-delay: -" + minuteAngle + "s";

            secondHand.style.cssText = "animation-delay: -" + secondAngle + "s";

        }



    }

    clock.go();

    clock.showdate();

    setInterval("clock.showdate()", 1000);

</script>

</body>



</html>