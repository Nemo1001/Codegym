package com.company;

import java.util.Date;

public class hienthithoigian {
    public static void main(String[] args) {
        private long startTime;
        private long endTime;

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }
        public void start () {
            this.startTime = System.currentTimeMillis();
        }

        public void stop () {
            this.endTime = System.currentTimeMillis();
        }


        public long getElapsedTime() {
            return (this.getEndTime() - this.getStartTime());
        }
    }