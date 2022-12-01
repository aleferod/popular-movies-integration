kubectl -n popular-movies-integration rollout restart deployment popular-movies-integration
kubectl apply -f ./
aws --endpoint-url=http://192.168.49.2:31554 sqs create-queue --queue-name rate-movie


#PERFORMANCE TESTING
artillery run --output /home/alefe/popular-movies/performance-tests-results/report.json /home/alefe/popular-movies/popular-movies-integration/app/tests/performance-test.yml
artillery report --output /home/alefe/popular-movies/performance-tests-results/report.html /home/alefe/popular-movies/performance-tests-results/report.json