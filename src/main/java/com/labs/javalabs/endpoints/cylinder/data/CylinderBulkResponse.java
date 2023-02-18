package com.labs.javalabs.endpoints.cylinder.data;

import java.util.List;

public record CylinderBulkResponse(StatsMapper stats, List<Cylinder> values) {
}
