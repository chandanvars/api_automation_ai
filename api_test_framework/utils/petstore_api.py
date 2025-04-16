import requests

class PetStoreAPI:
    def __init__(self, base_url):
        self.base_url = base_url

    def get_pet_by_id(self, pet_id):
        response = requests.get(f"{self.base_url}/pet/{pet_id}")
        return response.json()

    def add_new_pet(self, pet_data):
        headers = {'Content-Type': 'application/json'}
        response = requests.post(f"{self.base_url}/pet", json=pet_data, headers=headers)
        return response.status_code