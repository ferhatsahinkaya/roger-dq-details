build: build-image
run: run-image

build-image:
	./gradlew clean build --info
	$(call docker_build)

run-image:
	docker run roger/dq-details

define docker_build
	docker build --file=dist/docker/Dockerfile \
	--rm \
	-t roger/dq-details:latest .

endef