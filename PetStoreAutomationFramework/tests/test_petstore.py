import unittest
from utils.petstore_api import PetStoreAPI
from config import config

class TestPetStore(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        cls.api = PetStoreAPI(config['base_url'])

    def test_add_pet(self):
        # Test adding a new pet to the PetStore
        pass

    def test_edit_pet(self):
        # Test editing an existing pet's details
        pass

    def test_delete_pet(self):
        # Test deleting a pet from the PetStore
        pass

    def test_search_pet(self):
        # Test searching for pets in the PetStore
        pass

if __name__ == '__main__':
    unittest.main()