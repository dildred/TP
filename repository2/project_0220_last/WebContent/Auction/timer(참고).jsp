<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<HTML>
<HEAD>
<SCRIPT language=JavaScript> 

function getTime() { 

now = new Date(); 
dday = new Date(20,08,12,23,00); 

// 원하는 날짜, 시간 정확하게 초단위까지 기입.

days = (dday - now) / 1000 / 60 / 60 / 24; 

daysRound = Math.floor(days); 

hours = (dday - now) / 1000 / 60 / 60 - (24 * daysRound); 

hoursRound = Math.floor(hours); 

minutes = (dday - now) / 1000 /60 - (24 * 60 * daysRound) - (60 * hoursRound); 

minutesRound = Math.floor(minutes); 

seconds = (dday - now) / 1000 - (24 * 60 * 60 * daysRound) - (60 * 60 * hoursRound) - (60 * minutesRound); 

secondsRound = Math.round(seconds); 

document.getElementById("counter1").innerHTML = hoursRound; 

document.getElementById("counter2").innerHTML = minutesRound; 

document.getElementById("counter3").innerHTML = secondsRound; 

newtime = window.setTimeout("getTime();", 1000); 

} 

</SCRIPT>


<DIV id=count>

<SPAN id=counter1></SPAN>시간
<SPAN id=counter2></SPAN>분 
<SPAN id=counter3></SPAN>초 

<SPAN style="padding-left:30px;"></SPAN></div>

<SCRIPT>getTime()</SCRIPT>
</HEAD>


</HTML>