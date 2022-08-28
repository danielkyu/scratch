import importlib.resources
import yaml


def getConfig():
    return yaml.safe_load(importlib.resources.read_text("res", "config.yaml"))
