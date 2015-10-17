// Morris.js Charts sample data for SB Admin template

$(function() {

    // Area Chart
    Morris.Area({
        element: 'morris-area-chart',
        data: [{
                period: '2010 Q1',
                30240: 2666,
                8258: null,
                50233: 2647
            }, {
                period: '2010 Q2',
                30240: 2778,
                8258: 2294,
                50233: 2441
            }, {
                period: '2010 Q3',
                30240: 4912,
                8258: 1969,
                50233: 2501
            }, {
                period: '2010 Q4',
                30240: 3767,
                8258: 3597,
                50233: 5689
            }, {
                period: '2011 Q1',
                30240: 6810,
                8258: 1914,
                50233: 2293
            }, {
                period: '2011 Q2',
                30240: 5670,
                8258: 4293,
                50233: 1881
            }, {
                period: '2011 Q3',
                30240: 4820,
                8258: 3795,
                50233: 1588
            }, {
                period: '2011 Q4',
                30240: 15073,
                8258: 5967,
                50233: 5175
            }, {
                period: '2012 Q1',
                30240: 10687,
                8258: 4460,
                50233: 2028
            }, {
                period: '2012 Q2',
                30240: 8432,
                8258: 5713,
                50233: 1791
            }],
        xkey: 'period',
        ykeys: ['30240', '8258', '50233'],
        labels: ['30240', '8258', '50233'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });

    // Donut Chart
    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
                label: "Concluídas",
                value: 12
            }, {
                label: "Em Produção",
                value: 11
            }, {
                label: "Atrasadas",
                value: 3
            }, {
                label: "Canceladas",
                value: 2
            }],
        resize: true
    });

    // Line Chart
    /*
     Morris.Line({
     // ID of the element in which to draw the chart.
     element: 'morris-line-chart',
     // Chart data records -- each entry in this array corresponds to a point on
     // the chart.
     data: [{
     d: '2012-10-01',
     visits: 802
     }, {
     d: '2012-10-02',
     visits: 783
     }, {
     d: '2012-10-03',
     visits: 820
     }, {
     d: '2012-10-04',
     visits: 839
     }, {
     d: '2012-10-05',
     visits: 792
     }, {
     d: '2012-10-06',
     visits: 859
     }, {
     d: '2012-10-07',
     visits: 790
     }, {
     d: '2012-10-08',
     visits: 1680
     }, {
     d: '2012-10-09',
     visits: 1592
     }, {
     d: '2012-10-10',
     visits: 1420
     }, {
     d: '2012-10-11',
     visits: 882
     }, {
     d: '2012-10-12',
     visits: 889
     }, {
     d: '2012-10-13',
     visits: 819
     }, {
     d: '2012-10-14',
     visits: 849
     }, {
     d: '2012-10-15',
     visits: 870
     }, {
     d: '2012-10-16',
     visits: 1063
     }, {
     d: '2012-10-17',
     visits: 1192
     }, {
     d: '2012-10-18',
     visits: 1224
     }, {
     d: '2012-10-19',
     visits: 1329
     }, {
     d: '2012-10-20',
     visits: 1329
     }, {
     d: '2012-10-21',
     visits: 1239
     }, {
     d: '2012-10-22',
     visits: 1190
     }, {
     d: '2012-10-23',
     visits: 1312
     }, {
     d: '2012-10-24',
     visits: 1293
     }, {
     d: '2012-10-25',
     visits: 1283
     }, {
     d: '2012-10-26',
     visits: 1248
     }, {
     d: '2012-10-27',
     visits: 1323
     }, {
     d: '2012-10-28',
     visits: 1390
     }, {
     d: '2012-10-29',
     visits: 1420
     }, {
     d: '2012-10-30',
     visits: 1529
     }, {
     d: '2012-10-31',
     visits: 1892
     }, ],
     // The name of the data record attribute that contains x-visitss.
     xkey: 'd',
     // A list of names of data record attributes that contain y-visitss.
     ykeys: ['visits'],
     // Labels for the ykeys -- will be displayed when you hover over the
     // chart.
     labels: ['Visits'],
     // Disables line smoothing
     smooth: false,
     resize: true
     });
     */
    /*
     // Bar Chart
     Morris.Bar({
     element: 'morris-bar-chart',
     data: [{
     device: 'iPhone',
     geekbench: 136
     }, {
     device: 'iPhone 3G',
     geekbench: 137
     }, {
     device: 'iPhone 3GS',
     geekbench: 275
     }, {
     device: 'iPhone 4',
     geekbench: 380
     }, {
     device: 'iPhone 4S',
     geekbench: 655
     }, {
     device: 'iPhone 5',
     geekbench: 1571
     }],
     xkey: 'device',
     ykeys: ['geekbench'],
     labels: ['Geekbench'],
     barRatio: 0.4,
     xLabelAngle: 35,
     hideHover: 'auto',
     resize: true
     });
     */

});
