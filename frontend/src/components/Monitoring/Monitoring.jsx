import React, { useEffect, useState, Component } from 'react';

import { Chart } from 'chart.js/auto';
import { Line, Chart as ChartJS } from "react-chartjs-2";
import useStyles from './styles';

const Monitoring = () => {
    const classes = useStyles();

    const data = {
        labels: ["1", "2", "3", "4", "5", "6"],
        datasets: [
          {
            label: "First dataset",
            data: [33, 53, 85, 41, 44, 65],
            fill: true,
            backgroundColor: "rgba(75,192,192,0.2)",
            borderColor: "rgba(75,192,192,1)"
          },
          {
            label: "Second dataset",
            data: [33, 25, 35, 51, 54, 76],
            fill: false,
            borderColor: "#742774"
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