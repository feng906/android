#!/data/data/com.termux/files/usr/bin/bash

echo "进入项目目录 ~/android"
cd ~/android || { echo "找不到项目目录"; exit 1; }

echo "清理旧的构建缓存..."
./gradlew clean || { echo "清理失败"; exit 1; }

echo "开始编译 Debug APK..."
./gradlew assembleDebug || { echo "编译失败"; exit 1; }

APK_PATH=$(find ./app/build/outputs/apk/debug/ -name "*.apk" | head -n 1)

if [ -f "$APK_PATH" ]; then
    echo "APK生成成功：$APK_PATH"
    echo "复制APK到 /sdcard/Download/"
    cp "$APK_PATH" /sdcard/Download/ || { echo "复制失败"; exit 1; }
    echo "完成！你可以打开手机文件管理器，在“下载”文件夹找到APK文件。"
else
    echo "没有找到APK文件，编译可能失败了。"
    exit 1
fi

