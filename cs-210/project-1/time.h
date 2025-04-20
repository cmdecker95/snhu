#ifndef TIME_H
#define TIME_H

void initializeTime(int *hours, int *minutes, int *seconds);
void displayTime(int hours, int minutes, int seconds);
void addHour(int *hours);
void addMinute(int *hours, int *minutes);
void addSecond(int *hours, int *minutes, int *seconds);

#endif