.PHONY: build checkstyle test

run-dist:
	cd app && ./build/install/app/bin/app

build:
	cd app && ./gradlew clean build

checkstyle:
	cd app && ./gradlew checkstyleMain

test:
	cd app && ./gradlew test