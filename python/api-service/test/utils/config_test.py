from src.utils import config as cfg


def test_getConfigEnv():
    config = cfg.getConfig()

    assert config["env"] == "dev"
