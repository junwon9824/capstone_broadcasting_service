import React, { useEffect, useState, Component } from 'react';
import axios from 'axios';

import { CssBaseline, Grid, Button, IconButton, Input, Tabs, Tab, Box, Typography} from '@material-ui/core';
import { AddCircleRounded, Close, Settings, Delete, TiWeatherCloudy, TiWeatherDownpour, TiWeatherShower, TiWeatherSnow, TiWeatherStormy, TiWeatherSunny, BsCloudFog } from '@material-ui/icons';

import useStyles from './styles';

const Weather = ({ coord }) => {
    const classes = useStyles();
    const state = { temp: 0, desc: '', icon: '', loading: true }
    
    var lat = coord.latitude
    var lon = coord.longitude

    const [weather, setWeather] = useState('');
    const apiKey = "0ed94acfdf3d964a63cef8ef450e21f6";

    const apiCall = async () => {
        //e.preventDefault()
        const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${apiKey}`;
        const req = axios.get(url);
        const res = await req;
        setWeather({
            icon: res.data.weather[0].icon,
            descp: res.data.weather[0].description,
            temp: res.data.main.temp,
            city: res.data.name,
            humidity: res.data.main.humidity,
            press: res.data.main.pressure,
        });
    }
    
    let k = weather.temp;
    let C = k - 273.15;
    let imgurl = `https://openweathermap.org/img/w/${weather.icon}.png`;

    const Weath = () => {
        return (
            <div className={classes.weatherdiv} onLoad={() => apiCall()}>
                <div className="Weath">
                    {/* <img className="welement" src={require(url(imgurl))} alt=""/> */}
                    <div className="welement">
                        마을 날씨 : &nbsp;{weather.descp}
                    </div>
                    <div className="welement">
                        마을 기온 : &nbsp;{C.toFixed(2)} &#8451;
                    </div>
                    <div className="welement">
                        마을 습도 : &nbsp;{weather.humidity} %
                    </div>
                    <div className="welement">
                        마을 기압 : &nbsp;{weather.press} mb
                    </div><br/><br/>
                    <Button onClick={() => apiCall()}>reload</Button>
                </div>
            </div>
        );
    }
    return (
        <>
            <Weath />
        </>
    );
}

export default Weather;