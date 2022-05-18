# EagleEye
마이크로서비스 아키텍처에서 모니터링을 위한 테스트  
&nbsp;  

## 🚲요약
Kubernetes에서 Spring boot 서비스가 동작중인 환경을 Prometheus-stack(Prometheus+Grafana)로
모니터링해보는 테스트입니다.  
&nbsp;  

## 🔥Prerequisite  
- Spring boot
- Kubernetes
- Docker
- Helm
- Prometheus-stack  
&nbsp;  

## 🌏환경
<p align="center"><img src="/images/rpi.jpg" width="30%"></img></p>  

### 📌Raspberry pi 4B x 4  
- CPU  
-- Broadcom BCM2711 Quad core Cortex-A72 (ARM v8) 64-bit SoC @ 1.5GHz
- Memory  
-- 4GB
- Storage  
-- SanDisk Ultra A1 Micro SD card 64GB
- Network  
-- wlan0 x 2 / eth0 x 2  

### 📌Software  
- OS  
-- Ubuntu 20.04.4 LTS
- kernel  
-- Linux version 5.4.0-1060-raspi (buildd@bos02-arm64-051)
- Spring boot  
-- 2.6.7
- Kubernetes  
-- clinetVersion : 1.24.0  
-- kustomizeVersion : 4.5.4  
-- serverVersion : 1.24.0  
- Docker  
-- Client : 20.10.16  
-- Server/Engine : 20.10.16  
-- Server/containerd : 1.6.4  
-- Server/runc : 1.1.1  
-- Server/docker-init : 0.19.0  
- Helm  
-- 3.7.0
- Prometheus-stack  
-- kube-prometheus-stack : 35.2.0  
-- kube-state-metrics : 4.7.*  
-- prometheus-node-exporter : 3.1.*  
-- grafana : 6.29.*
