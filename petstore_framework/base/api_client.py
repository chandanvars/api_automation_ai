import requests

class APIClient:
    def __init__(self, base_url):
        self.base_url = base_url

    def send_request(self, method, endpoint, **kwargs):
        url = f"{self.base_url}{endpoint}"
        response = requests.request(method, url, **kwargs)
        return response