#!/bin/bash
seq 0 5000 | xargs -P200 -I{} curl -s http://localhost:8080/cylinder?height={}&radius={}
