package com.labs.javalabs.endpoints.cylinder.data;

import java.util.DoubleSummaryStatistics;

public record StatsMapper(double min, double max, double average) {
    public StatsMapper(DoubleSummaryStatistics stat) {
        this(stat.getMin(), stat.getMax(), stat.getAverage());
    }
}
