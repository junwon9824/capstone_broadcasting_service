import React, { useEffect, useState, Component } from 'react';
import Modal from 'react-modal';

import { Table, TableHead, TableRow, TableCell, TableContainer, Paper, TableBody } from '@material-ui/core';

import useStyles from './styles';

const TownDetail = ({town}) => {
    const classes = useStyles();

    return (
        <div className={classes.tablebody}>
            <TableContainer component={Paper}>
                <Table aria-label="simple table">
                    <TableRow key={town.devuser} sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                        <TableCell component="th" scope="row">단말기</TableCell>
                        <TableCell align="right">{town.devusers}</TableCell>
                    </TableRow>
                    <TableRow key={town.devuser} sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                        <TableCell component="th" scope="row">어플</TableCell>
                        <TableCell align="right">{town.appusers}</TableCell>
                    </TableRow>
                    <TableRow key={town.devuser} sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                        <TableCell component="th" scope="row">보호자</TableCell>
                        <TableCell align="right">{town.guardians}</TableCell>
                    </TableRow>
                    <TableRow key={town.devuser} sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                        <TableCell component="th" scope="row">긴급 호출</TableCell>
                        <TableCell align="right">{town.emergencycall}</TableCell>
                    </TableRow>
                    <TableRow key={town.devuser} sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                        <TableCell component="th" scope="row">통신 장애</TableCell>
                        <TableCell align="right">{town.communicationfail}</TableCell>
                    </TableRow>
                </Table>
            </TableContainer>
        </div>
    );
}

export default TownDetail;