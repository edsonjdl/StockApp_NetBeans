<%-- 
    Document   : comparerPerformance
    Created on : 2017-04-24, 14:39:05
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>amStock Example</title>
		<link rel="stylesheet" href="../amcharts/style.css"	type="text/css">

		<script src="../amcharts/amcharts.js" type="text/javascript"></script>
		<script src="../amcharts/serial.js" type="text/javascript"></script>
		<script src="../amcharts/amstock.js" type="text/javascript"></script>

		<script>
			AmCharts.ready(function () {
				generateChartData();
				createStockChart();
			});

			var chartData1 = [];
			var chartData2 = [];
			var chartData3 = [];
			var chartData4 = [];

			function generateChartData() {
				var firstDate = new Date();
				firstDate.setDate(firstDate.getDate() - 1500);
				firstDate.setHours(0, 0, 0, 0);

				for (var i = 0; i < 1500; i++) {
					var newDate = new Date(firstDate);
					newDate.setDate(newDate.getDate() + i);

					var a1 = Math.round(Math.random() * (40 + i)) + 100 + i;
					var b1 = Math.round(Math.random() * (1000 + i)) + 500 + i * 2;

					var a2 = Math.round(Math.random() * (100 + i)) + 200 + i;
					var b2 = Math.round(Math.random() * (1000 + i)) + 600 + i * 2;

					var a3 = Math.round(Math.random() * (100 + i)) + 200;
					var b3 = Math.round(Math.random() * (1000 + i)) + 600 + i * 2;

					var a4 = Math.round(Math.random() * (100 + i)) + 200 + i;
					var b4 = Math.round(Math.random() * (100 + i)) + 600 + i;

					chartData1.push({
						date: newDate,
						value: a1,
						volume: b1
					});
					chartData2.push({
						date: newDate,
						value: a2,
						volume: b2
					});
					chartData3.push({
						date: newDate,
						value: a3,
						volume: b3
					});
					chartData4.push({
						date: newDate,
						value: a4,
						volume: b4
					});
				}
			}

			function createStockChart() {
				var chart = new AmCharts.AmStockChart();

				// DATASETS //////////////////////////////////////////
				// create data sets first
				var dataSet1 = new AmCharts.DataSet();
				dataSet1.title = "first data set";
				dataSet1.fieldMappings = [{
					fromField: "value",
					toField: "value"
				}, {
					fromField: "volume",
					toField: "volume"
				}];
				dataSet1.dataProvider = chartData1;
				dataSet1.categoryField = "date";

				var dataSet2 = new AmCharts.DataSet();
				dataSet2.title = "second data set";
				dataSet2.fieldMappings = [{
					fromField: "value",
					toField: "value"
				}, {
					fromField: "volume",
					toField: "volume"
				}];
				dataSet2.dataProvider = chartData2;
				dataSet2.categoryField = "date";

				var dataSet3 = new AmCharts.DataSet();
				dataSet3.title = "third data set";
				dataSet3.fieldMappings = [{
					fromField: "value",
					toField: "value"
				}, {
					fromField: "volume",
					toField: "volume"
				}];
				dataSet3.dataProvider = chartData3;
				dataSet3.categoryField = "date";

				var dataSet4 = new AmCharts.DataSet();
				dataSet4.title = "fourth data set";
				dataSet4.fieldMappings = [{
					fromField: "value",
					toField: "value"
				}, {
					fromField: "volume",
					toField: "volume"
				}];
				dataSet4.dataProvider = chartData4;
				dataSet4.categoryField = "date";

				// set data sets to the chart
				chart.dataSets = [dataSet1, dataSet2, dataSet3, dataSet4];

				// PANELS ///////////////////////////////////////////
				// first stock panel
				var stockPanel1 = new AmCharts.StockPanel();
				stockPanel1.showCategoryAxis = false;
				stockPanel1.title = "Value";
				stockPanel1.percentHeight = 70;

				// graph of first stock panel
				var graph1 = new AmCharts.StockGraph();
				graph1.valueField = "value";
				graph1.comparable = true;
				graph1.compareField = "value";
				graph1.bullet = "round";
				graph1.bulletBorderColor = "#FFFFFF";
				graph1.bulletBorderAlpha = 1;
				graph1.balloonText = "[[title]]:<b>[[value]]</b>";
				graph1.compareGraphBalloonText = "[[title]]:<b>[[value]]</b>";
				graph1.compareGraphBullet = "round";
				graph1.compareGraphBulletBorderColor = "#FFFFFF";
				graph1.compareGraphBulletBorderAlpha = 1;
				stockPanel1.addStockGraph(graph1);

				// create stock legend
				var stockLegend1 = new AmCharts.StockLegend();
				stockLegend1.periodValueTextComparing = "[[percents.value.close]]%";
				stockLegend1.periodValueTextRegular = "[[value.close]]";
				stockPanel1.stockLegend = stockLegend1;


				// second stock panel
				var stockPanel2 = new AmCharts.StockPanel();
				stockPanel2.title = "Volume";
				stockPanel2.percentHeight = 30;
				var graph2 = new AmCharts.StockGraph();
				graph2.valueField = "volume";
				graph2.type = "column";
				graph2.showBalloon = false;
				graph2.fillAlphas = 1;
				stockPanel2.addStockGraph(graph2);

				var stockLegend2 = new AmCharts.StockLegend();
				stockLegend2.periodValueTextRegular = "[[value.close]]";
				stockPanel2.stockLegend = stockLegend2;

				// set panels to the chart
				chart.panels = [stockPanel1, stockPanel2];


				// OTHER SETTINGS ////////////////////////////////////
				var sbsettings = new AmCharts.ChartScrollbarSettings();
				sbsettings.graph = graph1;
				sbsettings.updateOnReleaseOnly = false;
				chart.chartScrollbarSettings = sbsettings;

				// CURSOR
				var cursorSettings = new AmCharts.ChartCursorSettings();
				cursorSettings.valueBalloonsEnabled = true;
				chart.chartCursorSettings = cursorSettings;


				// PERIOD SELECTOR ///////////////////////////////////
				var periodSelector = new AmCharts.PeriodSelector();
				periodSelector.position = "left";
				periodSelector.periods = [{
					period: "DD",
					count: 10,
					label: "10 days"
				}, {
					period: "MM",
					selected: true,
					count: 1,
					label: "1 month"
				}, {
					period: "YYYY",
					count: 1,
					label: "1 year"
				}, {
					period: "YTD",
					label: "YTD"
				}, {
					period: "MAX",
					label: "MAX"
				}];
				chart.periodSelector = periodSelector;


				// DATA SET SELECTOR
				var dataSetSelector = new AmCharts.DataSetSelector();
				dataSetSelector.position = "left";
				chart.dataSetSelector = dataSetSelector;

				chart.write('chartdiv');
			}
		</script>
	</head>
	<body style="background-color:#FFFFFF">
		<div id="chartdiv" style="width:100%; height:600px;"></div>
	</body>

</html>