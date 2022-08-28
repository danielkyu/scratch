import logging

from fastapi import FastAPI

from src.container import Container
from src.routes import routes
from src.utils import config as cfg


def createApp() -> FastAPI:
    # Configure logging
    logging.config.fileConfig("res/logger.ini", disable_existing_loggers=False)

    # Initialize the managed dependencies
    container = Container()

    container.config.from_dict(cfg.getConfig())

    app = FastAPI()
    app.container = container

    # Register all routers
    for router in routes.ROUTERS:
        app.include_router(router)

    return app


app = createApp()
