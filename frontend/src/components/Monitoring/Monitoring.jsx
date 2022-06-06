import React, { useEffect, useState, Component } from 'react';

import { Chart } from 'chart.js/auto';
import { Line, Chart as ChartJS } from "react-chartjs-2";
import useStyles from './styles';

const Monitoring = () => {
    const classes = useStyles();
    var zero = new Date();
    var one = new Date(zero.setDate(zero.getDate()-1));
    var two = new Date(zero.setDate(zero.getDate()-1));
    var three = new Date(zero.setDate(zero.getDate()-1));

    const data = {
        labels: [`${three.getDate()} 12AM`, `${three.getDate()} 12PM`, `${two.getDate()} 12AM`
        , `${two.getDate()} 12PM`, `${one.getDate()} 12AM`, `${one.getDate()} 12PM`],

        datasets: [
          {
            label: "온도",
            data: [20, 21, 22, 19, 20, 25],
            fill: true,
            backgroundColor: "rgba(75,192,192,0.2)",
            borderColor: "rgba(75,192,192,1)"
          },
          {
            label: "습도",
            data: [33, 30, 29, 35, 31, 30],
            fill: false,
            borderColor: "#742774"
          },
          {
            label: "긴급호출 (0/1)",
            data: [0, 0, 0, 0, 10, 0],
            fill: false,
            borderColor: "#FFA6A6"
          }
        ]
      };

    return (
        <div className={classes.body}>
            <Line data={data} />
        </div>
    );
}

export default Monitoring;