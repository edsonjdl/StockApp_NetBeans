<%-- 
    Document   : afficherHistorique
    Created on : 2017-04-24, 14:35:33
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>amStock Example</title>
        <link rel="stylesheet" href="../amcharts/style.css"
              type="text/css">
        <script src="../amcharts/amcharts.js" type="text/javascript"></script>
        <script src="../amcharts/serial.js" type="text/javascript"></script>
        <script src="../amcharts/amstock.js" type="text/javascript"></script>

        <script>
            AmCharts.ready(function () {
                generateChartData();
                createStockChart();
            });

            var chart;
            var chartDataCot = [];
            var newPanel; // panel qui sera ajouté ou enlevé
            var stockPanel1;
            
            

            function generateChartData() {
                var firstDate = new Date();
                firstDate.setHours(0, 0, 0, 0);
                firstDate.setDate(firstDate.getDate() - 2000);

                for (var i = 0; i < 2000; i++) {
                    var newDate = new Date(firstDate);

                    newDate.setDate(newDate.getDate() + i);

                    var open = Math.round(Math.random() * (30) + 100);
                    var close = open + Math.round(Math.random() * (15) - Math.random() * 10);

                    var low;
                    if (open < close) {
                        low = open - Math.round(Math.random() * 5);
                    } else {
                        low = close - Math.round(Math.random() * 5);
                    }

                    var high;
                    if (open < close) {
                        high = close + Math.round(Math.random() * 5);
                    } else {
                        high = open + Math.round(Math.random() * 5);
                    }

                    var volume = Math.round(Math.random() * (1000 + i)) + 100 + i;



                    chartDataCot[i] = ({
                        date: newDate,
                        open: open,
                        close: close,
                        high: high,
                        low: low,
                        volume: volume
                    });
                }
            }



            function createStockChart() {
                chart = new AmCharts.AmStockChart();

                chart.balloon.horizontalPadding = 13;

                // DATASET //////////////////////////////////////////
                var dataSetCot = new AmCharts.DataSet();
                dataSetCot.fieldMappings = [{
                        fromField: "open",
                        toField: "open"
                    }, {
                        fromField: "close",
                        toField: "close"
                    }, {
                        fromField: "high",
                        toField: "high"
                    }, {
                        fromField: "low",
                        toField: "low"
                    }, {
                        fromField: "volume",
                        toField: "volume"
                    }, {
                        fromField: "value",
                        toField: "value"
                    }];
                dataSetCot.color = "#7f8da9";
                dataSetCot.dataProvider = chartData;
                dataSetCot.categoryField = "date";

                chart.dataSets = [dataSetCot];

                // PANELS ///////////////////////////////////////////
                stockPanel1 = new AmCharts.StockPanel();
                stockPanel1.title = "Value";

                // graph of first stock panel
                var graph = new AmCharts.StockGraph();
                graph.type = "candlestick";
                graph.openField = "open";
                graph.closeField = "close";
                graph.highField = "high";
                graph.lowField = "low";
                graph.valueField = "close";
                graph.lineColor = "#7f8da9";
                graph.fillColors = "#7f8da9";
                graph.negativeLineColor = "#db4c3c";
                graph.negativeFillColors = "#db4c3c";
                graph.fillAlphas = 1;
                graph.balloonText = "open:<b>[[open]]</b><br>close:<b>[[close]]</b><br>low:<b>[[low]]</b><br>high:<b>[[high]]</b>";
                graph.useDataSetColors = false;
                stockPanel.addStockGraph(graph);

                var stockLegend = new AmCharts.StockLegend();
                stockLegend.markerType = "none";
                stockLegend.markerSize = 0;
                stockLegend.valueTextRegular = undefined;
                stockLegend.valueWidth = 250;
                stockPanel1.stockLegend = stockLegend;

                chart.panels = [stockPanel1];


                // OTHER SETTINGS ////////////////////////////////////
                var sbsettings = new AmCharts.ChartScrollbarSettings();
                sbsettings.graph = graph;
                sbsettings.graphType = "line";
                sbsettings.usePeriod = "WW";
                chart.chartScrollbarSettings = sbsettings;

                // Enable pan events
                var panelsSettings = new AmCharts.PanelsSettings();
                panelsSettings.panEventsEnabled = true;
                chart.panelsSettings = panelsSettings;

                // CURSOR
                var cursorSettings = new AmCharts.ChartCursorSettings();
                cursorSettings.valueBalloonsEnabled = true;
                cursorSettings.fullWidth = true;
                cursorSettings.cursorAlpha = 0.1;
                chart.chartCursorSettings = cursorSettings;

                // PERIOD SELECTOR ///////////////////////////////////
                var periodSelector = new AmCharts.PeriodSelector();
                periodSelector.position = "bottom";
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


                chart.write('chartdiv');
            }



            function addPanel() {
                newPanel = new AmCharts.StockPanel();
                newPanel.allowTurningOff = true;
                newPanel.title = "Volume";
                newPanel.showCategoryAxis = false;

                var graph = new AmCharts.StockGraph();
                graph.valueField = "volume";
                graph.fillAlphas = 0.15;
                newPanel.addStockGraph(graph);

                var legend = new AmCharts.StockLegend();
                legend.markerType = "none";
                legend.markerSize = 0;
                newPanel.stockLegend = legend;

                chart.addPanelAt(newPanel, 1);
                chart.validateNow();

                document.getElementById("addPanelButton").disabled = true;
                document.getElementById("removePanelButton").disabled = false;
            }

            function removePanel() {
                chart.removePanel(newPanel);
                chart.validateNow();

                document.getElementById("addPanelButton").disabled = false;
                document.getElementById("removePanelButton").disabled = true;
            }

        </script>
    </head>
    <body style="background-color:#FFFFFF">
    <input type="button" id="addPanelButton" onclick="addPanel()" value="Ajouter Panneau">
    <input type="button" disabled="true" id="removePanelButton" onclick="removePanel()"
           value="Supprimer panneau">
    <div id="chartdiv" style="width:100%; height:600px;"></div>
</body>

</html>
