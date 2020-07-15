/*
 * HeatMapMarkerCallback.java
 *
 * Copyright 2020 Heartland Software Solutions Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the license at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ca.hss.heatmaplib;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;

/**
 * A callback to allow markers to be drawn over the heatmap at each data point.
 * Created by Travis Redpath on 11/3/2017.
 */
public interface HeatMapMarkerCallback {

    /**
     * Draw a marker at the location of a data point.
     * @param canvas The canvas that the heatmap is being drawn on.
     * @param x The X location on the canvas that the marker should be drawn.
     * @param y The Y location on the canvas that the marker should be drawn.
     * @param point The data point that is being drawn.
     */
    void drawMarker(Canvas canvas, float x, float y, HeatMap.DataPoint point);

    class CircleHeatMapMarker implements HeatMapMarkerCallback {

        private Paint paint = new Paint();

        public CircleHeatMapMarker(@ColorInt int color) {
            paint.setColor(color);
        }

        @Override
        public void drawMarker(Canvas canvas, float x, float y, HeatMap.DataPoint point) {
            canvas.drawCircle(x, y, 10, paint);
        }
    }
}
