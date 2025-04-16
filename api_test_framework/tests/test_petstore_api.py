import pytest
from utils.petstore_api import PetStoreAPI

def test_get_pet_by_id():
    api = PetStoreAPI('http://test.petstore.swagger.io/v2')
    pet_id = 1
    response = api.get_pet_by_id(pet_id)
    assert response['id'] == pet_id, "Pet ID does not match"

# Additional test cases will be defined here.