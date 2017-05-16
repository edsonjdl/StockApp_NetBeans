<%-- 
    Document   : newjsp
    Created on : 2017-04-24, 16:08:27
    Author     : 1695625
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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

                var firstDate = new Date(2012, 0, 1);
                firstDate.setDate(firstDate.getDate() - 500);
                firstDate.setHours(0, 0, 0, 0);

                // Action principale
            <c:forEach var="item1" items="${maListe}"  varStatus="loop1">
                var newDate1 = new Date(firstDate);
                        newDate1.setDate(newDate1.getDate() + ${loop1.index});

                        var value1 = '${item1.fermeture}';
                        var volume1 = '${item1.volFin}';

                chartData1.push({
                    date: newDate1,
                    value: value1,
                    volume: volume1
                });



            </c:forEach>

                // Comparateur 1
            <c:forEach var="item2" items="${comp1}"  varStatus="loop2">
                var newDate2 = new Date(firstDate);
                        newDate2.setDate(newDate2.getDate() + ${loop2.index});

                        var value2 = '${item2.fermeture}';
                        var volume2 = '${item2.volFin}';

                chartData2.push({
                    date: newDate2,
                    value: value2,
                    volume: volume2
                });

            </c:forEach>

                // Comparateur 2
            <c:forEach var="item3" items="${comp2}"  varStatus="loop3">
                var newDate3 = new Date(firstDate);
                        newDate3.setDate(newDate3.getDate() + ${loop3.index});

                        var value3 = '${item3.fermeture}';
                        var volume3 = '${item3.volFin}';

                chartData3.push({
                    date: newDate3,
                    value: value3,
                    volume: volume3
                });

            </c:forEach>

                // Comparateur 3
            <c:forEach var="item4" items="${comp3}"  varStatus="loop4">
                var newDate4 = new Date(firstDate);
                        newDate4.setDate(newDate4.getDate() + ${loop4.index});

                        var value4 = '${item4.fermeture}';
                        var volume4 = '${item4.volFin}';

                chartData4.push({
                    date: newDate4,
                    value: value4,
                    volume: volume4
                });

            </c:forEach>


            }

            function createStockChart() {
                var chart = new AmCharts.AmStockChart();

                // DATASETS //////////////////////////////////////////
                // create data sets first
                var dataSet1 = new AmCharts.DataSet();
                dataSet1.title = "${codeReference}";
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
                dataSet2.title = "${comparateur1}";
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
                dataSet3.title = "${comparateur2}";
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
                dataSet4.title = "${comparateur3}";
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

        </br>
        </br>
        <a href="../accueil.jsp">Retour</a>
    </body>

</html>
