[![Release](https://jitpack.io/v/ca.heartlandsoftware/androidheatmap.svg)](https://jitpack.io/#ca.heartlandsoftware/androidheatmap)
[![API](https://img.shields.io/badge/API-18%2B-yellow.svg?style=flat)](https://android-arsenal.com/api?level=18)
[![Apache 2](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://github.com/HeartlandSoftware/AndroidHeatMap/blob/master/LICENSE)

# AndroidHeatMap

[**AndroidHeatMap**](https://github.com/HeartlandSoftware/AndroidHeatMap) is an easy to use heat map control for Android apps.

![Example View](https://raw.githubusercontent.com/HeartlandSoftware/AndroidHeatMap/master/images/screen.png)

## Installation

There are three different ways to use this library:

**1. Gradle dependency** (recommended)

- Add the following to your project level `build.gradle`:

```gradle
allprojects {
	repositories {
		maven { url "https://jitpack.io" }
	}
}
```
- Add this to your app `build.gradle`:

```gradle
dependencies {
	implementation 'ca.heartlandsoftware:androidheatmap:1.2.0'
}
```

**2. Maven**
- Add the following to the `<repositories>` section of your `pom.xml`:

```xml
<repository>
	<id>jitpack.io</id>
	<url>https://jitpack.io</url>
</repository>
```
- Add the following to the `<dependencies>` section of your `pom.xml`:

```xml
<dependency>
	<groupId>ca.heartlandsoftware</groupId>
	<artifactId>androidheatmap</artifactId>
	<version>1.2.0</version>
</dependency>
```

**3. Clone the whole repository**
 - Open your **commandline-input** and navigate to the desired destination folder on your machine (where you want to place the library)
 - Use the command `git clone https://github.com/HeartlandSoftware/AndroidHeatMap.git` to download the full AndroidHeatMap repository to your computer (this includes the folder of the library as well as the folder of the example project)
 - Import the library folder (`AndroidHeatMap`) into Android Studio (recommended) or your Eclipse workspace
 - Add it as a reference to your project: 
   - [referencing library projects in Eclipse](http://developer.android.com/tools/projects/projects-eclipse.html#ReferencingLibraryProject)
   - [managing projects from Android Studio](https://developer.android.com/sdk/installing/create-project.html)

## Getting Started

Add a HeatMap control to your xml layout.

```xml
<ca.hss.heatmaplib.HeatMap
    android:id="@+id/heatmap"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:minOpacity="0"
    app:maxOpacity="255" />
```

Back in your activity or fragment you would get a reference to the BottomSheetLayout like any other view.
```java
HeatMap heatMap = (HeatMap) findViewById(R.id.heatmap);
```

Set the range that you want the heat maps gradient to cover.

```java
heatMap.setMinimum(0.0);
heatMap.setMaximum(100.0);
```

Now you can add data to the heat map.

```java
//add random data to the map
Random rand = new Random();
for (int i = 0; i < 20; i++) {
    HeatMap.DataPoint point = new HeatMap.DataPoint(rand.nextFloat(), rand.nextFloat(), rand.nextDouble() * 100.0);
    heatMap.addData(point);
}
```

## Options

### Colour Gradient

Changing the colour gradient.

```java
//make the colour gradient from pink to yellow
Map<Float, Integer> colorStops = new ArrayMap<>();
colors.put(0.0f, 0xffee42f4);
colors.put(1.0f, 0xffeef442);
heatMap.setColorStops(colors);
```

### Opacity

Set the minimum and maximum opacity of the heat map. The value is an 2 byte alpha value with the range [0,255].

```java
//make the minimum opacity completely transparent
heatMap.setMinimumOpactity(0);
//make the maximum opacity 50% transparent
heatMap.setMaximumOpacity(127);
```

Or set it in xml.

```xml
<ca.hss.heatmaplib.HeatMap
    app:minOpacity="0"
    app:maxOpacity="255" />
```

### Radius

Set the radius of each points coloured gradient.

```java
//set the radius to 300 pixels.
heatMap.setRadius(300);
```

Or in xml.

```xml
<ca.hss.heatmaplib.HeatMap
    app:radius="100dp" />
```

### HeatMap Size

If you are seeing ```OutOfMemoryError``` thrown on some devices this can be used to reduce the size of the bitmap that the HeatMap is rendered on to reduce memory usage.

```java
//set the maximum width to 400px
heatMap.setMaxDrawingWidth(400);
```

Or in xml.

```xml
<ca.hss.heatmaplib.HeatMap
    app:maxDrawingWidth="200dp" />
```

### Draw Data Markers

Markers can be drawn on the HeatMap to indicate where the data points are located. The markers are drawn in a callback to allow any app to decide how the marker should be drawn. An example callback is included that draws a simple circle at the data point.

```java
//draw a dark violet circle at the location of each data point
heatMap.setMarkerCallback(new HeatMapMarkerCallback.CircleHeatMapMarker(0xff9400D3));
```

### Refresh

After changing an option after the heat map has been rendered force a refresh.

```java
heatMap.forceRefresh();
```

## License

Copyright 2020 Heartland Software Solutions Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
implied. See the License for the specific language governing
permissions and limitations under the License.
