<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='js/index.global.js'></script>
<script>

  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var events = []; // events 변수를 초기화합니다.

    // Ajax Call
    fetch('eventList.do')
    .then(result => result.json())
    .then(eventListCallback)
    .catch(err => console.error(err));
    
    function eventListCallback(result) {
      console.log(events);
      result.forEach(item => {
        events.push({title: item.title, start: item.startDate, end: item.endDate});
      });

      var calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },
        initialDate: '2025-04-12',
        navLinks: true, // can click day/week names to navigate views
        selectable: true,
        selectMirror: true,
        select: async function(arg) { // async로 변경
          console.log(arg);
          var title = prompt('Event Title:');
          
          if (title) {
            // start와 end를 arg에서 가져옵니다.
            let allDay = arg.allDay;
            let startStr = allDay ? arg.startStr : arg.startStr.substring(0, 19);
            let endStr = allDay ? arg.endStr : arg.endStr.substring(0, 19);
            let xhtp = await fetch('addEvent.do?title=' + title + '&start=' + startStr + '&end=' +endStr);
            let result = await xhtp.json();
            if (result.retCode == 'OK') {
              calendar.addEvent({
                title: title,
                start: arg.start,
                end: arg.end,
                allDay: arg.allDay
              });
            }
          }
          calendar.unselect();
        },
        eventClick: async function (arg) {
            console.log(arg);
            if (confirm('Are you sure you want to delete this event?')) {
              let xhtp = await fetch('removeEvent.do?title=' +arg.event.title + '&start=' + arg.event.startStr + '&end=' + arg.event.endStr);
              let result = await xhtp.json();
              if (result.retCode == 'OK') {
                arg.event.remove();
              } else {
                alert('Transaction error!');
              }
            }
          },
        editable: true,
        dayMaxEvents: true, // allow "more" link when too many events
        events: events
      });

      calendar.render(); // calendar.render()를 올바른 위치로 이동
    } // eventListCallback 함수의 끝

  });

</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<div id='calendar'></div>

</body>
</html>
