	$(document).ready(function() {
		
		$('#calendar').fullCalendar({
			locale: 'es',
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,basicWeek,basicDay'
			},
			defaultDate: '2018-10-01',
			navLinks: true, // can click day/week names to navigate views
			editable: true,
			eventLimit: true, // allow "more" link when too many events
			events: [
				{
					title: 'Camila',
					start: '2018-10-01'
				},
				{
					title: 'Prueba',
					start: '2018-10-07',
					end: '2018-10-09'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2018-10-23'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2018-10-23'
				},
				{
					title: 'Conference',
					start: '2018-10-27',
					end: '2018-10-28'
				},
				{
					title: 'Meeting',
					start: '2016-12-12T10:30:00',
					end: '2016-12-12T12:30:00'
				},
				{
					title: 'Lunch',
					start: '2016-12-12T12:00:00'
				},
				{
					title: 'Meeting',
					start: '2016-12-12T14:30:00'
				},
				{
					title: 'Happy Hour',
					start: '2016-12-12T17:30:00'
				},
				{
					title: 'Dinner',
					start: '2016-12-12T20:00:00'
				},
				{
					title: 'Birthday Party',
					start: '2016-12-13T07:00:00'
				},
				{
					title: 'Click for Google',
					url: 'https://google.com/',
					start: '2016-12-28'
				}
			]
		});
		
	});