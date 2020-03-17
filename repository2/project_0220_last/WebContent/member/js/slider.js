	$(function() {

		$("#hover_menu").hide();
		$("#hover_menu div[class!='inner']").hide();

		$("#menu .links #m1").on("mouseover", function() {
			$("#hover_menu div[class!='inner']").hide();
			$("#hover_menu #h" + $(this).attr("id")).show();
			$("#hover_menu").stop().slideDown();
		});

		$("#menu .links #m1").on("mouseout", function() {
			$("#hover_menu").stop().slideUp();
		});
		$("#hover_menu").on("mouseover", function() {
			$("#hover_menu").stop().slideDown();
		});
		$("#hover_menu").on("mouseout", function() {
			$("#hover_menu").stop().slideUp();
		});

		$("#hover_menu1").hide();
		$("#hover_menu1 div[class!='inner']").hide();

		$("#menu .links #m2").on("mouseover", function() {
			$("#hover_menu1 div[class!='inner']").hide();
			$("#hover_menu1 #h" + $(this).attr("id")).show();
			$("#hover_menu1").stop().slideDown();
		});

		$("#menu .links #m2").on("mouseout", function() {
			$("#hover_menu1").stop().slideUp();
		});
		$("#hover_menu1").on("mouseover", function() {
			$("#hover_menu1").stop().slideDown();
		});
		$("#hover_menu1").on("mouseout", function() {
			$("#hover_menu1").stop().slideUp();
		});

		$("#hover_menu2").hide();
		$("#hover_menu2 div[class!='inner']").hide();

		$("#menu .links #m3").on("mouseover", function() {
			$("#hover_menu2 div[class!='inner']").hide();
			$("#hover_menu2 #h" + $(this).attr("id")).show();
			$("#hover_menu2").stop().slideDown();
		});

		$("#menu .links #m3").on("mouseout", function() {
			$("#hover_menu2").stop().slideUp();
		});
		$("#hover_menu2").on("mouseover", function() {
			$("#hover_menu2").stop().slideDown();
		});
		$("#hover_menu2").on("mouseout", function() {
			$("#hover_menu2").stop().slideUp();
		});
	});