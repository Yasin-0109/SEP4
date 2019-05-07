
/*
 * temp_hum.h
 *
 * Created: 07/05/2019 13.31.52
 *  Author: Roza
 */ 

#ifndef TEMP_HUMSENSORS_H_
#define TEMP_HUMSENSORS_H_

#include "ATMEGA_FreeRTOS.h"

#include <stdbool.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <hih8120.h>
#include <serial.h>



void temp_hum_sensors_init();
void temp_hum_measure();
float temp_get_value();
float hum_get_value();


#endif /* TEMP_HUMSENSORS_H_ */